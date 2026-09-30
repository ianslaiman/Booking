public class TransportTicketFactory implements TicketFactory{
    public Ticket createTicket() {
        TransportTicketBuilder ticketBuilder = new TransportTicketBuilder();
        Ticket ticket = ticketBuilder.getTicket();
        return ticket;
    }
}
