package UI_Format;

import Facade.BookingFacade;
import Facade.BookingCoordinator; // <-- Import the coordinator
import Profile.ProfilePrimary;

public class App {
    public static void main(String[] args) {
        // --- STEP 1: UI INITIALIZATION ---
        System.out.println("=== INITIALIZING UI LAYOUT & FORMS ===");
        UILayout.ScreenHome homeScreen = new UILayout.ScreenHome();
        homeScreen.display();

        MobileForm mobileForm = new MobileForm();
        mobileForm.display();

        DesktopForm desktopForm = new DesktopForm();
        desktopForm.display();

        System.out.println();

        // --- STEP 2: MEDIATOR SETUP ---
        // Retrieve and configure the Profile singleton
        ProfilePrimary userProfile = ProfilePrimary.getProfile();
        userProfile.setFullName("John Doe");

        // Wire the Mediator
        BookingCoordinator coordinator = new BookingCoordinator(userProfile);
        userProfile.setMediator(coordinator);

        // TRIGGER THE MEDIATOR: Changing the nationality notifies the Mediator,
        // which will automatically change the UILayout language!
        userProfile.setNationality("Spanish");

        System.out.println();

        // --- STEP 3: IMPLEMENTING BOOKINGS WITH FACADE ---
        BookingFacade bookingFacade = new BookingFacade();

        // Book a Transport ticket
        bookingFacade.processBooking(userProfile, "Transport");

        // Book a Hotel ticket
        bookingFacade.processBooking(userProfile, "Hotel");
    }
}