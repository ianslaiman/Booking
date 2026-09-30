public class HotelTicketFactory implements TicketFactory{
    public Ticket createTicket() {
        HotelTicketBuilder ticketBuilder = new HotelTicketBuilder();
        Ticket ticket = ticketBuilder.getTicket();
        return ticket;
    }
}
