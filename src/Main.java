import Booking.*;
import Facade.*;
import Profile.*;
import UI_Format.*;
import TicketFolder.*;
import TicketPrices.*;
import Decorator.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ticket> reservations = new ArrayList<>();
        boolean UserOnline = true;
        boolean ProfileCreated = false;
        ProfileBuilder profileBuilder = new ProfileBuilder();
        while(UserOnline == true){
            System.out.println("Welcome to the Booking System!");
            System.out.println("If new please make a profile!");
            System.out.println("Please select an option:");
            System.out.println("1. Book a Transport Ticket");
            System.out.println("2. Book a Hotel Ticket");
            System.out.println("3. View/Make Profile");
            System.out.println("4. Reservations");
            System.out.println("5. Exit");
            int option = 0;

            ProfileBuilder profile = new ProfileBuilder();
            Scanner scanner = new Scanner(System.in);
            
            option = scanner.nextInt();
            switch(option)
            {
                case 1:

                if(ProfileCreated == false)
                {
                    System.out.println("Please Create a Profile first before continuing");
                    break;
                }

                TicketFactory transportTicketFactory = ticketFactory("Transport");
                Ticket transportTicket = transportTicketFactory.createTicket();
                TransportTicketBuilder builderTravel = new TransportTicketBuilder();

                int TicketIdentifierTravel = Random8Digit();
                int TicketPriceTravel = PriceTransport();
                String TicketBrandTravel = BrandTransport();
                String TicketDateTravel = Date();
                String TicketTypeTravel = "Transport";
                String TicketDestinationTravel = DestinationTransport();
                String TicketOriginTravel = OriginTransport();
                String TicketDocumentTravel = PassportNumber();;
                int CreditCard = CreditCard();

                builderTravel.buildTicketIdentifier(TicketIdentifierTravel);
                builderTravel.buildTicketPrice(TicketPriceTravel);
                builderTravel.buildTicketBrand(TicketBrandTravel);
                builderTravel.buildTicketDate(TicketDateTravel);
                builderTravel.buildTicketType(TicketTypeTravel);
                builderTravel.buildTicketDestination(TicketDestinationTravel);
                builderTravel.buildTicketOrigin(TicketOriginTravel);
                builderTravel.buildTicketDocumentRequired(TicketDocumentTravel);
                builderTravel.buildCreditCard(CreditCard);

                transportTicket = builderTravel.getTicket();

                System.out.println(transportTicket);

                reservations.add(transportTicket);

                case 2:

                if(ProfileCreated == false)
                {
                    System.out.println("Please Create a Profile first before continuing");
                    break;
                }

                TicketFactory hotelTicketFactory = ticketFactory("Hotel");
                Ticket hotelTicket = hotelTicketFactory.createTicket();
                HotelTicketBuilder builderHotel = new HotelTicketBuilder();

                int TicketIdentifierHotel = Random8Digit();
                int TicketPriceHotel = PriceHotel();
                String TicketBrandHotel = BrandHotel();
                String TicketDateHotel = Date();
                String TicketTypeHotel = "Hotel";
                String TicketDestinationHotel = DestinationHotel();
                String TicketDocumentHotel = PassportNumber();;
                CreditCard = CreditCard();

                builderHotel.buildTicketIdentifier(TicketIdentifierHotel);
                builderHotel.buildTicketPrice(TicketPriceHotel);
                builderHotel.buildTicketBrand(TicketBrandHotel);
                builderHotel.buildTicketDate(TicketDateHotel);
                builderHotel.buildTicketType(TicketTypeHotel);
                builderHotel.buildTicketDestination(TicketDestinationHotel);
                builderHotel.buildTicketDocumentRequired(TicketDocumentHotel);
                builderHotel.buildCreditCard(CreditCard);

                hotelTicket = builderHotel.getTicket();

                System.out.println(hotelTicket);

                reservations.add(hotelTicket);

                case 3:

                if(ProfileCreated == false)
                {
                    
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Please enter your full name please.");
                    String name = scan.nextLine();
                    profileBuilder.setFullName(name);
                    System.out.println("Please enter your full email please.");
                    String email = scan.nextLine();
                    profileBuilder.setEmail(email);
                    int phoneNumber = phoneNumber();
                    profileBuilder.setPhoneNumber(phoneNumber);
                    String address = address();
                    profileBuilder.setAddress(address);
                    System.out.println("Please put in your date of birth");
                    String DOB = scan.nextLine();
                    profileBuilder.setDateOfBirth(DOB);
                    System.out.println("Please put in your gender");
                    String Gender = scan.nextLine();
                    profileBuilder.setGender(Gender);
                    System.out.println("Please put in your nationality");
                    String Nationality = scan.nextLine();
                    profileBuilder.setNationality(Nationality);
                    ProfilePrimary profile1 = profileBuilder.getProfile();
                    System.out.println(profile1.toString());
                    break;
                }

                ProfilePrimary profileNew = profileBuilder.getProfile();
                System.out.println(profileNew);

                case 4:
                    
                System.out.println("Here are you reservations:");
                System.out.println(reservations);
                
                case 5:
                    UserOnline = false;
                    break;

                default:
                System.out.println("Invalid option try again please");
            }
        }
    }

    static int Random8Digit()
    {
        Random random = new Random();

        int number = 10000000 + random.nextInt(90000000);

        System.out.println(number);
        return number;
    }

    static int PriceTransport()
    {
        int price = 0;
        boolean breaker = false;
        BookingInter booking = new FlightBooking();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select your ticket type");
        System.out.println("1. Standard \n2. Business \n3. First Class");
        int option = scanner.nextInt();

        while(breaker == false){
            switch(option)
            {
                case 1:
                    breaker = true;
                    break;
                case 2:
                    booking = new BusinessClass(booking);
                    breaker = true;
                    break;
                case 3:
                    booking = new FirstClass(booking);
                    breaker = true;
                    break;
                default:
                    System.out.println("Unknown input");
            }
        }

        breaker = false;

        while(breaker == false){
            System.out.println("What bonuses do you want one your flight");
            System.out.println("1. Extra Luggage \n2. RentACar \n3. Exit");
            int option1 = scanner.nextInt();
            switch(option1)
            {
                case 1:
                    booking = new ExtraLuggage(booking);
                    break;
                case 2:
                    booking = new RentACar(booking);
                    break;
                case 3:
                    breaker = true;
                    break;
                default:
                    System.out.println("Unknown input");
            }
        }

        System.out.println("final reciept" + booking);

        double finalprice = booking.getPrice();

        price = (int)finalprice;

        System.out.println("The final price will be " + price + "€");

        return price;
    }

    static String BrandTransport()
    {
        String brand = "";
        boolean breaker = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("Which airline would you like to travel on?");
        System.out.println("1. Ryanair \n2. Iberia \n3. Lufthansa");
        int option = scan.nextInt();
        while(breaker == false){
            switch(option)
            {
                case 1:
                    brand = "Ryanair";
                    breaker = true;
                    break;
                case 2:
                    brand = "Iberia";
                    breaker = true;
                    break;
                case 3:
                    brand = "Lufthansa";
                    breaker = true;
                    break;
                default:
                    System.out.println("Unknown input");
            }
        }
        return brand;
    }

    static String Date()
    {
        System.out.println("Please insert the year you want to travel");
        int year = 0;
        int month = 0;
        int day = 0;
        String time = "";

        String Date = "";
        boolean breaker = false;
        Scanner scan = new Scanner(System.in);

        while(breaker == false)
        {
            int input = scan.nextInt();
            if(input == 2026 || input == 2027)
            {
                year = input;
                breaker = true;
            }
            else
            {
                System.out.println("insert a valid date");
            }
        }
        breaker = false;

        System.out.println("Please input a month");
        while(breaker == false)
        {
            int input = scan.nextInt();
            if(year == 2026 && input < 10)
            {
                System.out.print("Please insert a valid date");
            }
            else
            {
                month = input;
                breaker = true;
            }
        }
        breaker = false;

        System.out.println("Please input a day");
        while(breaker == false)
        {
            int input = scan.nextInt();
            if(1 > input || input > 30)
            {
                System.out.print("Please insert a valid date");
            }
            else
            {
                day = input;
                breaker = true;
            }
        }

        breaker = false;
        System.out.println("Please select a time");
        System.out.println("1. 12:00 \n2. 18:30 \n 22:45");
        while(breaker == false)
        {
            int option = scan.nextInt();

            switch(option)
            {
                case 1:
                    time = "12:00";
                    breaker = true;
                case 2: 
                    time = "18:30";
                    breaker = true;
                case 3:
                    time = "22:45";
                    breaker = true;
                default:
                    System.out.println("Please insert a vaild time");

            }
        }
        String Finaldate = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year) + " at " + time;
        Date = Finaldate;

        return Date;
    }

    static String DestinationTransport()
    {
        String Destination = "";
        boolean breaker = false;
        System.out.println("Please select where you would like to go");
        System.out.println("1. Berlin, Germany \n2. Venice, Italy \n3. Paris, France \n4.Brussels, Belgium \n5. Lisbon, Portugal");
        Scanner scan = new Scanner(System.in);
        while(breaker == false)
        {
            int input = scan.nextInt();
            switch(input)
            {
                case 1: 
                    Destination = "Berlin,Germany";
                    breaker = true;
                case 2:
                    Destination = "Venice, Italy";
                    breaker = true;
                case 3:
                    Destination = "Paris, France";
                    breaker = true;
                case 4:
                    Destination = "Brussels, Belgium";
                    breaker = true;
                case 5: 
                    Destination = "Lisbon, Portugal";
                    breaker = true;
                default:
                    System.out.println("Please select a valid option");
            }
        }
        return Destination;
    }

    static String OriginTransport()
    {
        String Origin = "";
        boolean breaker = false;
        System.out.println("Please select where you would like to travel from");
        System.out.println("1. Terminal 1 \n2. Terminal 2 \n3. Terminal 3 \n4.Terminal 4 \n5. Terminal 4-S");
        Scanner scan = new Scanner(System.in);
        while(breaker == false)
        {
            int input = scan.nextInt();
            switch(input)
            {
                case 1: 
                    Origin = "Terminal 1";
                    breaker = true;
                case 2:
                    Origin = "Terminal 2";
                    breaker = true;
                case 3:
                    Origin = "Terminal 3";
                    breaker = true;
                case 4:
                    Origin = "Terminal 4";
                    breaker = true;
                case 5: 
                    Origin = "Terminal 4-S";
                    breaker = true;
                default:
                    System.out.println("Please select a valid option");
            }
        }

        return Origin;
    }

    static int PriceHotel()
    {
        int price = 0;
        boolean breaker = false;
        BookingInter booking = new HotelBookingDec();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select your room type");
        System.out.println("1. Standard \n2. LargerRoom \n3. VIPRoom");
        int option = scanner.nextInt();

        while(breaker == false){
            switch(option)
            {
                case 1:
                    breaker = true;
                    break;
                case 2:
                    booking = new LargerRoom(booking);
                    breaker = true;
                    break;
                case 3:
                    booking = new VIPRoom(booking);
                    breaker = true;
                    break;
                default:
                    System.out.println("Unknown input");
            }
        }

        breaker = false;

        while(breaker == false){
            System.out.println("What bonuses do you want one your stay");
            System.out.println("1. Breakfast \n2. SpaAccess \n3. Exit");
            int option1 = scanner.nextInt();
            switch(option1)
            {
                case 1:
                    booking = new Breakfast(booking);
                    break;
                case 2:
                    booking = new SpaAccess(booking);
                    break;
                case 3:
                    breaker = true;
                    break;
                default:
                    System.out.println("Unknown input");
            }
        }
        System.out.println("final reciept" + booking);

        double finalprice = booking.getPrice();

        price = (int)finalprice;

        System.out.println("The final price will be " + price + "€");

        return price;
    }

    static String BrandHotel()
    {
        String Brand = "";
        boolean breaker = false;
        System.out.println("Please select from which brand of hotel you want");
        System.out.println("1. IHG Hotels\n2. Accor Hotels\n3. Choice Hotels\n4. Hyatt Hotels\n5. Hilton Hotels");
        Scanner scan = new Scanner(System.in);
        while(breaker == false)
        {
            int input = scan.nextInt();
            switch(input)
            {
                case 1: 
                    Brand = "IHG Hotels";
                    breaker = true;
                case 2:
                    Brand = "Accor Hotels";
                    breaker = true;
                case 3:
                    Brand = "Choice Hotels";
                    breaker = true;
                case 4:
                    Brand = "Hyatt Hotels";
                    breaker = true;
                case 5: 
                    Brand = "Hilton Hotels";
                    breaker = true;
                default:
                    System.out.println("Please select a valid option");
            }
        }
        return Brand;
    }

    static String DestinationHotel()
    {
        String Destination = "";
        boolean breaker = false;
        System.out.println("Please select where you would like for your hotel to be located in");
        System.out.println("1. Berlin, Germany \n2. Venice, Italy \n3. Paris, France \n4.Brussels, Belgium \n5. Lisbon, Portugal");
        Scanner scan = new Scanner(System.in);
        while(breaker == false)
        {
            int input = scan.nextInt();
            switch(input)
            {
                case 1: 
                    Destination = "Berlin,Germany";
                    breaker = true;
                case 2:
                    Destination = "Venice, Italy";
                    breaker = true;
                case 3:
                    Destination = "Paris, France";
                    breaker = true;
                case 4:
                    Destination = "Brussels, Belgium";
                    breaker = true;
                case 5: 
                    Destination = "Lisbon, Portugal";
                    breaker = true;
                default:
                    System.out.println("Please select a valid option");
            }
        }
        return Destination;
    }

    static int CreditCard()
    {
        int CreditCard = 0;
        boolean breaker = false;
        System.out.println("Please insert your credit card");
        Scanner scan = new Scanner(System.in);
        while(breaker == false)
        {
            String input = scan.nextLine();
            if(isValidCreditCard(input) == true)
            {
                CreditCard = Integer.parseInt(input);
                breaker = false;
            }else
            {
                System.out.println("Please put a valid card");
            }
        }
        return CreditCard;
    }

    static int phoneNumber()
    {
        int phoneNumber = 0;
        boolean breaker = false;
        System.out.println("Please input your phone number");
        Scanner scan = new Scanner(System.in);
        while(breaker == false)
        {
            int input = scan.nextInt();

            if (String.valueOf(input).length() == 9) {
                phoneNumber = input;
                breaker = true;
            } else {
                System.out.println("Not a valid phone number");
            }
        }
        return phoneNumber;
    }

    static String PassportNumber()
    {
        String passport = "";
        boolean breaker = false;
        System.out.println("Please input your passport number (8 numbers and 1 letter)");;
        Scanner scan = new Scanner(System.in);
        while(breaker == false)
        {
            String input = scan.nextLine();
            if (input.matches("[0-9]{8}[A-Za-z]")) {
                passport = input;
                breaker = true;
                System.out.println("valid number");
            } else {
                System.out.println("Please insert a valid passport");
            }
        }
        return passport;
    }

    static String address()
    {
        String Address = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input your Country");
        String input1 = scan.nextLine();
        System.out.println("Please input your Region");
        String input2= scan.nextLine();
        System.out.println("Please input your City");
        String input3 = scan.nextLine();
        System.out.println("Please input your Street");
        String input4 = scan.nextLine();
        Address = input1 + ", " + input2 + ", " + input3 + ", " + input4;
        System.out.println(Address);
        return Address;
    }

    static TicketFactory ticketFactory(String type)
    {
        switch (type) {
            case "Transport":
                return new TransportTicketFactory();
            case "Hotel":
                return new HotelTicketFactory();
            default:
                return new HotelTicketFactory();
            }
    }
    public static boolean isValidCreditCard(String cardNumber) {
        int sum = 0;
        boolean alternate = false;

        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));

            if (digit < 0 || digit > 9) {
                return false;
            }

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
}