package Booking;
import TicketFolder.*;
import Profile.*;

public class TransportBooking extends Booking {
    private Ticket ticket;
    private Profile profile;

    public TransportBooking(Ticket ticket) {
        this.ticket = ticket;
        this.profile = Profile.getProfile();
    }
}
