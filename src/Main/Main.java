package Main;

import Booking.*;
import Facade.*;
import Profile.*;
import UI_Format.*;
import TicketFolder.*;
import TicketPrices.*;

import java.util.Scanner;

public class Main {

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