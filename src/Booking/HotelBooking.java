package Booking;

import Profile.ProfilePrimary;
import TicketFolder.Ticket;

public class HotelBooking extends Booking {

    public HotelBooking(ProfilePrimary profile, Ticket ticket) {
        super(profile, ticket);
    }

    @Override
    protected void assignSpecificDetails() {
        System.out.println("[HotelBooking] Assigning Room #304 | Check-in: 14:00 | Complimentary Breakfast included.");
    }
}