package UI_Format;

import Facade.BookingFacade;

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

        // Book a Transport ticket
        bookingFacade.processBooking("Transport");

        // Book a Hotel ticket
        bookingFacade.processBooking("Hotel");
    }
}