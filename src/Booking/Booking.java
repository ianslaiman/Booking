package Booking;

import Profile.Profile;
import TicketFolder.Ticket;

public abstract class Booking {
    protected Profile profile;
    protected Ticket ticket;

    public Booking(Profile profile, Ticket ticket) {
        this.profile = profile;
        this.ticket = ticket;
    }

    // THE TEMPLATE METHOD: Fixed sequence of steps (marked final so subclasses cannot alter the order)
    public final void confirmBooking() {
        validateProfile();
        linkTicket();
        assignSpecificDetails(); // Step that varies by subclass
        printConfirmation();
    }

    // Common step 1
    private void validateProfile() {
        System.out.println("[Booking] Validating passenger: " + profile.getFullName() + " (Passport: " + profile.getPassportNumber() + ")");
    }

    // Common step 2
    private void linkTicket() {
        System.out.println("[Booking] Linking ticket type: " + ticket.toString());
    }

    // Variable step 3: Subclasses MUST implement this
    protected abstract void assignSpecificDetails();

    // Common step 4
    private void printConfirmation() {
        System.out.println("[Booking] Reservation confirmed and sent to: " + profile.getEmail() + "\n");
    }
}