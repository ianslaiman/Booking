import Booking.*;
import Facade.*;
import Profile.*;
import UI_Format.*;
import TicketFolder.*;
import TicketPrices.*;
import Decorator.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean UserOnline = true;
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

            boolean ProfileCreated = false;
            ProfileBuilder profile = new ProfileBuilder();
            Scanner scanner = new Scanner(System.in);
            
            option = scanner.nextInt();
            switch(option)
            {
                case 1:

                TransportTicket PlaneTicket = new TransportTicket();
                int TicketIdentifierTravel = 11593567;
                int TicketPriceTravel = PriceTransport();
                String TicketBrandTravel = BrandTransport();
                String TicketDateTravel = Date();
                String TicketTypeTravel = "Transport";
                String TicketDestinationTravel = DestinationTransport();
                String TicketOriginTravel = OriginTransport();
                String TicketDocumentTravel = PassportNumber;

                case 2:

                HotelTicket HotelTicket = new HotelTicket();
                int TicketIdentifierHotel = 11593567;
                int TicketPriceHotel = PriceHotel();
                String TicketBrandHotel = BrandHotel();
                String TicketDateHotel = Date();
                String TicketTypeHotel = "Hotel";
                String TicketDestinationHotel = DestinationHotel();
                String TicketDocumentHotel = PassportNumber;

                case 3:



                case 4:
                    
                
                case 5:
                    UserOnline = false;
                    break;

                default:
                System.out.println("Invalid option try again please");
            }
        }
    }

    static int PriceTransport()
    {
        int price = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select your ticket type");
        System.out.println("1. Standard \n2. Business \n3. First Class \n4. Exit");
        int option = scanner.nextInt();

        switch(option)
        {
            case 1:
                price = 125;
                break;
            case 2:
                price = 175;
                break;
            case 3:
                price = 250;
                break;
            case 4:
                break;
            default:
                System.out.println("Unknown input");
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