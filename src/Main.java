import Profile.*;
import TicketFolder.*;
import Decorator.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.function.UnaryOperator;

public class Main {
   
    private static final Scanner IN = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final Set<Integer> usedTicketIds = new HashSet<>();

    static final String[] AIRLINES = {"Ryanair", "Iberia", "Lufthansa"};
    static final String[] CITIES = {"Berlin, Germany", "Venice, Italy", "Paris, France", "Brussels, Belgium", "Lisbon, Portugal"};
    static final String[] TERMINALS = {"Terminal 1", "Terminal 2", "Terminal 3", "Terminal 4", "Terminal 4-S"};
    static final String[] HOTEL_BRANDS = {"IHG Hotels", "Accor Hotels", "Choice Hotels", "Hyatt Hotels", "Hilton Hotels"};
    static final String[] TIMES = {"12:00", "18:30", "22:45"};
    
    static final DateTimeFormatter TICKET_DATE = DateTimeFormatter.ofPattern("dd/MM/uuuu 'at' HH:mm");

    public static void main(String[] args) {
        try {
            run();
        } catch (NoSuchElementException e) {
            System.out.println();
            System.out.println("Input closed. Goodbye!");
        }
    }

    static void run() {
        ArrayList<Ticket> reservations = new ArrayList<>();
        boolean userOnline = true;
        boolean profileCreated = false;
        ProfileBuilder profileBuilder = new ProfileBuilder();

        while (userOnline) {
            System.out.println("Welcome to the Booking System!");
            System.out.println("If new please make a profile!");
            System.out.println("Please select an option:");
            System.out.println("1. Book a Transport Ticket");
            System.out.println("2. Book a Hotel Ticket");
            System.out.println("3. View/Make Profile");
            System.out.println("4. Reservations (view, cancel or change)");
            System.out.println("5. Exit");

            Integer option = parseInt(readLine());
            switch (option == null ? -1 : option) {
                case 1:
                case 2:
                    if (!profileCreated) {
                        System.out.println("Please Create a Profile first before continuing");
                        break;
                    }
                    Ticket booked = option == 1
                            ? bookTransport(profileBuilder.getProfile(), reservations)
                            : bookHotel(profileBuilder.getProfile(), reservations);
                    if (booked != null) {
                        reservations.add(booked);
                    }
                    break;

                case 3:
                    if (!profileCreated) {
                        createProfile(profileBuilder);
                        profileCreated = true;
                    }
                    System.out.println(profileBuilder.getProfile());
                    break;

                case 4:
                    reservationsMenu(reservations);
                    break;

                case 5:
                    userOnline = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option try again please");
            }
        }
    }

    // ------------------------------------------------------------------ bookings

    /** Returns the new ticket, or null if the user gave up because of a clashing booking. */
    static Ticket bookTransport(ProfilePrimary profile, List<Ticket> reservations) {
        TransportTicketBuilder builder = new TransportTicketBuilder();
        builder.buildTicketIdentifier(Random8Digit());
        builder.buildTicketPrice(PriceTransport());
        builder.buildTicketBrand(BrandTransport());
        String date = chooseFreeDate(reservations, true, null);
        if (date == null) {
            System.out.println("Booking cancelled. Nothing was charged.");
            return null;
        }
        builder.buildTicketDate(date);
        builder.buildTicketType("Transport");
        builder.buildTicketDestination(DestinationTransport());
        builder.buildTicketOrigin(OriginTransport());
        builder.buildTicketDocumentRequired(profile.getPassportNumber());
        builder.buildCreditCard(CreditCard());

        Ticket ticket = builder.getTicket();
        System.out.println("Booking confirmed:");
        System.out.println(ticket);
        return ticket;
    }

    /** Returns the new ticket, or null if the user gave up because of a clashing booking. */
    static Ticket bookHotel(ProfilePrimary profile, List<Ticket> reservations) {
        HotelTicketBuilder builder = new HotelTicketBuilder();
        builder.buildTicketIdentifier(Random8Digit());
        builder.buildTicketPrice(PriceHotel());
        builder.buildTicketBrand(BrandHotel());
        String date = chooseFreeDate(reservations, false, null);
        if (date == null) {
            System.out.println("Booking cancelled. Nothing was charged.");
            return null;
        }
        builder.buildTicketDate(date);
        builder.buildTicketType("Hotel");
        builder.buildTicketDestination(DestinationHotel());
        builder.buildTicketDocumentRequired(profile.getPassportNumber());
        builder.buildCreditCard(CreditCard());

        Ticket ticket = builder.getTicket();
        System.out.println("Booking confirmed:");
        System.out.println(ticket);
        return ticket;
    }

    // ------------------------------------------------------------------ reservations: view, cancel, change

    static void reservationsMenu(List<Ticket> reservations) {
        while (true) {
            if (reservations.isEmpty()) {
                System.out.println("You have no reservations yet.");
                return;
            }
            System.out.println("Here are your reservations:");
            printReservations(reservations);
            System.out.println("1. Cancel a reservation\n2. Change a reservation\n3. Back to main menu");
            int choice = readInt(1, 3);
            if (choice == 1) {
                cancelReservation(reservations);
            } else if (choice == 2) {
                changeReservation(reservations);
            } else {
                return;
            }
        }
    }

    static void printReservations(List<Ticket> reservations) {
        for (int i = 0; i < reservations.size(); i++) {
            System.out.println((i + 1) + ") " + reservations.get(i));
        }
    }

    /** Asks which reservation to act on; returns null if the user chooses 0 (back). */
    static Ticket pickReservation(List<Ticket> reservations, String action) {
        System.out.println("Which reservation do you want to " + action + "? (1-" + reservations.size() + ", 0 to go back)");
        int n = readInt(0, reservations.size());
        return n == 0 ? null : reservations.get(n - 1);
    }

    static void cancelReservation(List<Ticket> reservations) {
        Ticket ticket = pickReservation(reservations, "cancel");
        if (ticket == null) {
            return;
        }
        System.out.println(ticket);
        if (!readYesNo("Are you sure you want to cancel this reservation? (y/n)")) {
            System.out.println("Nothing was cancelled.");
            return;
        }
        reservations.remove(ticket);
        System.out.println("Reservation #" + ticket.getTicketIdentifier() + " cancelled. "
                + ticket.getTicketPrice() + "€ will be refunded to card " + ticket.getMaskedCreditCard() + ".");
    }

    static void changeReservation(List<Ticket> reservations) {
        Ticket ticket = pickReservation(reservations, "change");
        if (ticket == null) {
            return;
        }
        boolean transport = ticket instanceof TransportTicket;
        String[] fields = transport
                ? new String[] {"Date and time", "Airline", "Destination", "Departure terminal", "Ticket class and extras", "Credit card"}
                : new String[] {"Check-in date and time", "Hotel brand", "Location", "Room type and extras", "Credit card"};
        boolean changed = false;

        while (true) {
            System.out.println("Current reservation:");
            System.out.println(ticket);
            System.out.println("What would you like to change?");
            for (int i = 0; i < fields.length; i++) {
                System.out.println((i + 1) + ". " + fields[i]);
            }
            int done = fields.length + 1;
            System.out.println(done + ". Done");
            int choice = readInt(1, done);
            if (choice == done) {
                System.out.println(changed ? "Reservation #" + ticket.getTicketIdentifier() + " updated." : "No changes made.");
                return;
            }

            String field = fields[choice - 1];
            if (field.toLowerCase().contains("date")) {
                String date = chooseFreeDate(reservations, transport, ticket);
                if (date == null) {
                    System.out.println("Date not changed.");
                    continue;
                }
                ticket.setTicketDate(date);
            } else if (field.equals("Airline")) {
                ticket.setTicketBrand(BrandTransport());
            } else if (field.equals("Hotel brand")) {
                ticket.setTicketBrand(BrandHotel());
            } else if (field.equals("Destination")) {
                ticket.setTicketDestination(DestinationTransport());
            } else if (field.equals("Location")) {
                ticket.setTicketDestination(DestinationHotel());
            } else if (field.equals("Departure terminal")) {
                ticket.setTicketOrigin(OriginTransport());
            } else if (field.endsWith("extras")) {
                int oldPrice = ticket.getTicketPrice();
                int newPrice = transport ? PriceTransport() : PriceHotel();
                ticket.setTicketPrice(newPrice);
                if (newPrice > oldPrice) {
                    System.out.println("You will be charged " + (newPrice - oldPrice) + "€ more.");
                } else if (newPrice < oldPrice) {
                    System.out.println((oldPrice - newPrice) + "€ will be refunded to your card.");
                } else {
                    System.out.println("The price has not changed.");
                }
            } else if (field.equals("Credit card")) {
                ticket.setCreditCard(CreditCard());
            }
            changed = true;
        }
    }

    // ------------------------------------------------------------------ duplicate / clash detection

    /**
     * Asks for a date and makes sure it doesn't clash with an existing booking of the same kind:
     * a flight at the exact same date and time, or a hotel checking in on the same day.
     * Returns the date formatted for the ticket, or null if the user decides to stop.
     *
     * @param ignore the reservation being changed (so it doesn't clash with itself), or null
     */
    static String chooseFreeDate(List<Ticket> reservations, boolean transport, Ticket ignore) {
        while (true) {
            LocalDateTime when = Date(transport ? "travel" : "check in");
            Ticket clash = findClash(reservations, transport, when, ignore);
            if (clash == null) {
                return when.format(TICKET_DATE);
            }
            System.out.println(transport
                    ? "You already have a flight booked at that date and time:"
                    : "You already have a hotel booked with check-in on that day:");
            System.out.println(clash);
            System.out.println("1. Choose another date\n2. Stop");
            if (readInt(1, 2) == 2) {
                return null;
            }
        }
    }

    static Ticket findClash(List<Ticket> reservations, boolean transport, LocalDateTime when, Ticket ignore) {
        for (Ticket other : reservations) {
            if (other == ignore || (other instanceof TransportTicket) != transport) {
                continue;
            }
            LocalDateTime otherWhen = LocalDateTime.parse(other.getTicketDate(), TICKET_DATE);
            boolean clash = transport
                    ? otherWhen.equals(when)
                    : otherWhen.toLocalDate().equals(when.toLocalDate());
            if (clash) {
                return other;
            }
        }
        return null;
    }

    static void createProfile(ProfileBuilder profileBuilder) {
        profileBuilder.setFullName(readNonEmpty("Please enter your full name."));
        profileBuilder.setEmail(email());
        profileBuilder.setPhoneNumber(phoneNumber());
        profileBuilder.setAddress(address());
        profileBuilder.setDateOfBirth(dateOfBirth());
        profileBuilder.setGender(readNonEmpty("Please put in your gender"));
        profileBuilder.setNationality(readNonEmpty("Please put in your nationality"));
        profileBuilder.setPassportNumber(PassportNumber());
    }

    /** Unique 8-digit ticket number (never reused within a session). */
    static int Random8Digit() {
        int number;
        do {
            number = 10000000 + RANDOM.nextInt(90000000);
        } while (!usedTicketIds.add(number));
        return number;
    }

    // ------------------------------------------------------------------ pricing (decorators)

    static int PriceTransport() {
        BookingInter booking = new FlightBooking();
        System.out.println("Please select your ticket type");
        System.out.println("1. Standard\n2. Business\n3. First Class");
        int option = readInt(1, 3);
        if (option == 2) {
            booking = new BusinessClass(booking);
        } else if (option == 3) {
            booking = new FirstClass(booking);
        }

        booking = chooseExtras(booking, "flight",
                new String[] {"Extra Luggage", "Rent a car"},
                List.of(ExtraLuggage::new, RentACar::new));
        return finalPrice(booking);
    }

    static int PriceHotel() {
        BookingInter booking = new HotelBookingDec();
        System.out.println("Please select your room type");
        System.out.println("1. Standard\n2. Larger room\n3. VIP room");
        int option = readInt(1, 3);
        if (option == 2) {
            booking = new LargerRoom(booking);
        } else if (option == 3) {
            booking = new VIPRoom(booking);
        }

        booking = chooseExtras(booking, "stay",
                new String[] {"Breakfast", "Spa access"},
                List.of(Breakfast::new, SpaAccess::new));
        return finalPrice(booking);
    }

    /** Lets the user add each extra at most once, then choose "Done". */
    static BookingInter chooseExtras(BookingInter booking, String what, String[] names,
                                     List<UnaryOperator<BookingInter>> wrappers) {
        boolean[] added = new boolean[names.length];
        int done = names.length + 1;
        while (true) {
            System.out.println("What bonuses do you want on your " + what + "?");
            for (int i = 0; i < names.length; i++) {
                System.out.println((i + 1) + ". " + names[i] + (added[i] ? " (added)" : ""));
            }
            System.out.println(done + ". Done");
            int choice = readInt(1, done);
            if (choice == done) {
                return booking;
            }
            int i = choice - 1;
            if (added[i]) {
                System.out.println(names[i] + " is already added.");
            } else {
                booking = wrappers.get(i).apply(booking);
                added[i] = true;
            }
        }
    }

    static int finalPrice(BookingInter booking) {
        System.out.println("Final receipt: " + booking.getDescription());
        int price = (int) Math.round(booking.getPrice());
        System.out.println("The final price will be " + price + "€");
        return price;
    }

    // ------------------------------------------------------------------ choices

    static String BrandTransport() {
        System.out.println("Which airline would you like to travel on?");
        return choose(AIRLINES);
    }

    static String DestinationTransport() {
        System.out.println("Please select where you would like to go");
        return choose(CITIES);
    }

    static String OriginTransport() {
        System.out.println("Please select where you would like to travel from");
        return choose(TERMINALS);
    }

    static String BrandHotel() {
        System.out.println("Please select from which brand of hotel you want");
        return choose(HOTEL_BRANDS);
    }

    static String DestinationHotel() {
        System.out.println("Please select where you would like for your hotel to be located in");
        return choose(CITIES);
    }

    /** Prints a numbered list and returns the option the user picked. */
    static String choose(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        return options[readInt(1, options.length) - 1];
    }

    // ------------------------------------------------------------------ dates

    /**
     * Asks for a date and time from now until the end of next year.
     * Rejects impossible dates (month 13, 30 February...) and anything in the past.
     */
    static LocalDateTime Date(String purpose) {
        LocalDate today = LocalDate.now();
        int firstYear = today.getYear();
        int lastYear = firstYear + 1;
        while (true) {
            System.out.println("Please insert the year you want to " + purpose + " (" + firstYear + "-" + lastYear + ")");
            int year = readInt(firstYear, lastYear);
            System.out.println("Please input a month (1-12)");
            int month = readInt(1, 12);
            int lastDay = YearMonth.of(year, month).lengthOfMonth();
            System.out.println("Please input a day (1-" + lastDay + ")");
            int day = readInt(1, lastDay);

            LocalDate date = LocalDate.of(year, month, day);
            if (date.isBefore(today)) {
                System.out.println("That date is in the past. Please choose a date from "
                        + today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " onwards.");
                continue;
            }

            System.out.println("Please select a time");
            LocalDateTime when = LocalDateTime.of(date, LocalTime.parse(choose(TIMES)));
            if (!when.isAfter(LocalDateTime.now())) {
                System.out.println("That time has already passed today. Please choose another date or time.");
                continue;
            }
            return when;
        }
    }

    static String dateOfBirth() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/M/uuuu").withResolverStyle(ResolverStyle.STRICT);
        LocalDate today = LocalDate.now();
        System.out.println("Please put in your date of birth (DD/MM/YYYY)");
        while (true) {
            String input = readLine().trim();
            try {
                LocalDate dob = LocalDate.parse(input, format);
                if (!dob.isBefore(today)) {
                    System.out.println("Date of birth must be in the past");
                } else if (dob.isBefore(today.minusYears(130))) {
                    System.out.println("Please insert a realistic date of birth");
                } else {
                    return dob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                }
            } catch (DateTimeParseException e) {
                System.out.println("Please use the format DD/MM/YYYY with a real date");
            }
        }
    }

    // ------------------------------------------------------------------ personal / payment data

    static String CreditCard() {
        System.out.println("Please insert your credit card number");
        while (true) {
            String input = readLine().replaceAll("[\\s-]", "");
            if (input.matches("[0-9]{13,19}") && isValidCreditCard(input)) {
                return input;
            }
            System.out.println("Please put a valid card (13-19 digits)");
        }
    }

    static String phoneNumber() {
        System.out.println("Please input your phone number");
        while (true) {
            String input = readLine().replaceAll("[\\s-]", "");
            if (input.matches("\\+?[0-9]{9,15}")) {
                return input;
            }
            System.out.println("Not a valid phone number (9-15 digits, optional leading +)");
        }
    }

    static String email() {
        System.out.println("Please enter your email.");
        while (true) {
            String input = readLine().trim();
            if (input.matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
                return input;
            }
            System.out.println("Please insert a valid email (e.g. name@example.com)");
        }
    }

    static String PassportNumber() {
        System.out.println("Please input your passport number (8 numbers and 1 letter)");
        while (true) {
            String input = readLine().trim().toUpperCase();
            if (input.matches("[0-9]{8}[A-Z]")) {
                System.out.println("valid number");
                return input;
            }
            System.out.println("Please insert a valid passport");
        }
    }

    static String address() {
        String country = readNonEmpty("Please input your Country");
        String region = readNonEmpty("Please input your Region");
        String city = readNonEmpty("Please input your City");
        String street = readNonEmpty("Please input your Street");
        String address = country + ", " + region + ", " + city + ", " + street;
        System.out.println(address);
        return address;
    }

    /** Luhn checksum. Only plain ASCII digits are accepted; an empty string is not a card. */
    public static boolean isValidCreditCard(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            return false;
        }
        int sum = 0;
        boolean alternate = false;

        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            char c = cardNumber.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
            int digit = c - '0';

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        return sum % 10 == 0;
    }

    // ------------------------------------------------------------------ input helpers

    static String readLine() {
        return IN.nextLine();
    }

    /** Returns the number in the text, or null if it isn't a whole number. */
    static Integer parseInt(String text) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /** Keeps asking until the user types a whole number between min and max (inclusive). */
    static int readInt(int min, int max) {
        while (true) {
            Integer value = parseInt(readLine());
            if (value != null && value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a number from " + min + " to " + max);
        }
    }

    static boolean readYesNo(String prompt) {
        System.out.println(prompt);
        while (true) {
            String input = readLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            }
            if (input.equals("n") || input.equals("no")) {
                return false;
            }
            System.out.println("Please answer y or n");
        }
    }

    /** Prints the prompt and keeps asking until the answer is not blank. */
    static String readNonEmpty(String prompt) {
        System.out.println(prompt);
        while (true) {
            String input = readLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("This field cannot be empty");
        }
    }
}
