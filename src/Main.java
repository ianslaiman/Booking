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
        while(UserOnline = true){
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
                TransportTicketBuilder builder = new TransportTicketBuilder();

                int TicketIdentifierTravel = Random8Digit();
                int TicketPriceTravel = PriceTransport();
                String TicketBrandTravel = BrandTransport();
                String TicketDateTravel = Date();
                String TicketTypeTravel = "Transport";
                String TicketDestinationTravel = DestinationTransport();
                String TicketOriginTravel = OriginTransport();
                String TicketDocumentTravel = PassportNumber;
                int CreditCard = CreditCard();

                transportTicket = builder.getTicket();

                case 2:

                if(ProfileCreated == false)
                {
                    System.out.println("Please Create a Profile first before continuing");
                    break;
                }

                HotelTicket HotelTicket = new HotelTicket();
                int TicketIdentifierHotel = Random8Digit();
                int TicketPriceHotel = PriceHotel();
                String TicketBrandHotel = BrandHotel();
                String TicketDateHotel = Date();
                String TicketTypeHotel = "Hotel";
                String TicketDestinationHotel = DestinationHotel();
                String TicketDocumentHotel = PassportNumber;
                CreditCard = CreditCard();

                case 3:

                if(ProfileCreated == false)
                {
                    ProfileBuilder profileBuilder = new ProfileBuilder();
                    Scanner scan = new Scanner(System.in);
                    String name = scan.nextLine();
                    System.out.println("Please enter your full name please.");
                    profileBuilder.setFullName(name);
                    String email = scan.nextLine();
                    System.out.println("Please enter your full email please.");
                    profileBuilder.setEmail(email);
                    int phoneNumber = phoneNumber();
                    profileBuilder.setPhoneNumber();
                    profileBuilder.setAddress();
                    profileBuilder.setDateOfBirth();
                    profileBuilder.setGender();
                    profileBuilder.setNationality();
                    profileBuilder.setPassportNumber();
                    ProfilePrimary profile1 = profileBuilder.getProfile();
                    System.out.println(profile1.toString());
                    break;
                }

                case 4:
                    
                
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
        System.out.println("What bonuses do you want one your flight");
        System.out.println("1. Extra Luggage \n2. RentACar \n3. Exit");

        while(breaker == false){
            System.out.println("What bonuses do you want one your flight");
            System.out.println("1. Extra Luggage \n2. RentACar \n3. Exit");
            switch(option)
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

        return price;
    }

    static String BrandTransport()
    {
        String brand = "";
        return brand;
    }

    static String Date()
    {
        String Date = "";
        return Date;
    }

    static String DestinationTransport()
    {
        String Destination = "";
        return Destination;
    }

    static String OriginTransport()
    {
        String Origin = "";
        return Origin;
    }

    static int PriceHotel()
    {
        int Price = 0;
        return Price;
    }

    static String BrandHotel()
    {
        String Brand = "";
        return Brand;
    }

    static String DestinationHotel()
    {
        String Destination = "";
        return Destination;
    }

    static int CreditCard()
    {
        int CreditCard = 0;
        
        return CreditCard;
    }

    static int phoneNumber()
    {
        int phoneNumber = 0;
        return phoneNumber;
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
}
/* 
    public static boolean displayMenu(Profile profile) {
        System.out.println("\nWelcome to the Booking System!");
        System.out.println("Please select an option:");
        System.out.println("1. Book a Transport Ticket");
        System.out.println("2. Book a Hotel Ticket");
        System.out.println("3. View Profile");
        System.out.println("4. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        BookingFacade bookingFacade = new BookingFacade();
        switch(choice) {
            case 1:
                bookingFacade.processBooking(profile, "Transport");
                break;
            case 2:
                bookingFacade.processBooking(profile, "Hotel");
                break;
            case 3:
                System.out.println(profile.toString());
                break;
            case 4:
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    public static void main(String[] args) {

        // Setup Profile
        ProfileBuilder profileBuilder = new ProfileBuilder();
        profileBuilder.setFullName();
        profileBuilder.setEmail();
        profileBuilder.setPhoneNumber();
        profileBuilder.setAddress();
        profileBuilder.setDateOfBirth();
        profileBuilder.setGender();
        profileBuilder.setNationality();
        profileBuilder.setPassportNumber();

        Profile myProfile = Profile.getProfile();

        // --- MEDIATOR PATTERN SETUP ---
        BookingCoordinator coordinator = new BookingCoordinator(myProfile);
        myProfile.setMediator(coordinator);

        // Test the mediator by changing nationality
        myProfile.setNationality("Spanish");

        System.out.println("=== INITIALIZING UI LAYOUT & FORMS ===");
        UILayout.ScreenHome homeScreen = new UILayout.ScreenHome();
        homeScreen.display();

        // Loop
        while (true) {
            Boolean keepRunning = displayMenu(myProfile);
            if (!keepRunning) {
                break;
            }
        }
    }
}

*/