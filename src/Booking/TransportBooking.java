package Booking;

import Profile.ProfilePrimary;
import TicketFolder.Ticket;

public class TransportBooking extends Booking {

    public TransportBooking(ProfilePrimary profile, Ticket ticket) {
        super(profile, ticket);
    }

    @Override
    protected void assignSpecificDetails() {
        System.out.println("[TransportBooking] Assigning Seat 12A | Boarding Gate B4 | Priority Boarding enabled.");
    }
}