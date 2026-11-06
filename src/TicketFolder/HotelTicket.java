package TicketFolder;

// All fields, getters and setters are inherited from Ticket.
public class HotelTicket extends Ticket {
    @Override
    protected String getKind() {
        return "Hotel";
    }
}
