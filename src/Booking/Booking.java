package Booking;

import Profile.Profile;
import TicketFolder.Ticket;

public abstract class Booking {
    protected Profile profile;
    protected Ticket ticket;
    
    // State Pattern Reference
    private BookingState state;

    public Booking(Profile profile, Ticket ticket) {
        this.profile = profile;
        this.ticket = ticket;
        // All bookings start as PENDING
        this.state = new PendingState(); 
    }

    // --- STATE PATTERN METHODS ---
    public void setState(BookingState state) {
        this.state = state;
    }

    public BookingState getState() {
        return state;
    }

    public void advanceState() {
        // Delegates the action to the current state object
        state.next(this);
    }

    // --- TEMPLATE METHOD (Existing) ---
    public final void confirmBooking() {
        System.out.println("Current Booking Status: " + state.getStatusName());
        validateProfile();
        linkTicket();
        assignSpecificDetails();
        printConfirmation();
    }

    private void validateProfile() {
        System.out.println("[Booking] Validating passenger: " + profile.getFullName());
    }

    private void linkTicket() {
        System.out.println("[Booking] Linking ticket type: " + ticket.toString());
    }

    protected abstract void assignSpecificDetails();

    private void printConfirmation() {
        System.out.println("[Booking] Reservation confirmed and sent to: " + profile.getEmail() + "\n");
    }
}