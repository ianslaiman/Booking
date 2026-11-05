package UI_Format;

import Facade.BookingFacade;
import Profile.Profile;

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

        // --- STEP 2: IMPLEMENTING BOOKINGS WITH FACADE ---
        BookingFacade bookingFacade = new BookingFacade();

        // Retrieve and configure the Profile singleton
        Profile userProfile = Profile.getProfile();
        userProfile.setFullName("John Doe");

        // Book a Transport ticket
        bookingFacade.processBooking(userProfile, "Transport");

        // Book a Hotel ticket
        bookingFacade.processBooking(userProfile, "Hotel");
    }
}