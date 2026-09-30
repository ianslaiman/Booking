public class HotelTicketBuilder implements TicketBuilder {
    private Ticket ticket;

    public HotelTicketBuilder() {
        this.ticket = new HotelTicket();
    }

    public void buildTicketIdentifier() {
        ticket.setTicketIdentifier(0);
    }
    public void buildTicketPrice() {
        ticket.setTicketPrice(0);
    }
    public void buildTicketBrand() {
        ticket.setTicketBrand("");
    }
    public void buildTicketDate() {
        ticket.setTicketDate("");
    }
    public void buildTicketType() {
        ticket.setTicketType("");
    }
    public void buildTicketDestination() {
        ticket.setTicketDestintation("");
    }
    public void buildTicketOrigin() {
        ticket.setTicketOrigin("");
    }
    public void buildTicketDocumentRequired() {
        ticket.setTicketDocumentRequired("");
    }
    public Ticket getTicket() {
        return ticket;
    }
}
