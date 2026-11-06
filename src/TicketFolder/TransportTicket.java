package TicketFolder;

// All fields, getters and setters are inherited from Ticket.
public class TransportTicket extends Ticket {
    @Override
    protected String getKind() {
        return "Transport";
    }
}
