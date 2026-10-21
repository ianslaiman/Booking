package Booking;
import TicketFolder.*;
import Profile.*;

public class HotelBooking extends Booking {
    private Ticket ticket;
    private Profile profile;

    public HotelBooking(Ticket ticket) {
        this.ticket = ticket;
        this.profile = Profile.getProfile();
    }
}
