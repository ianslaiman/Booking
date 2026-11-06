package TicketFolder;

public class TransportTicketBuilder implements TicketBuilder {

    private Ticket ticket;

    public TransportTicketBuilder() {
        this.ticket = new TransportTicket();
    }

    @Override
    public void buildTicketIdentifier(int Identifier) {
        ticket.setTicketIdentifier(Identifier);
    }
    @Override
    public void buildTicketPrice(int Price) {
        ticket.setTicketPrice(Price);
    }
    @Override
    public void buildTicketBrand(String Brand) {
        ticket.setTicketBrand(Brand);
    }
    @Override
    public void buildTicketDate(String Date) {
        ticket.setTicketDate(Date);
    }
    @Override
    public void buildTicketType(String Type) {
        ticket.setTicketType(Type);
    }
    @Override
    public void buildTicketDestination(String Destination) {
        ticket.setTicketDestination(Destination);
    }
    @Override
    public void buildTicketOrigin(String Origin) {
        ticket.setTicketOrigin(Origin);
    }
    @Override
    public void buildTicketDocumentRequired(String Document) {
        ticket.setTicketDocumentRequired(Document);
    }
    @Override
    public void buildCreditCard(String Card) {
        ticket.setCreditCard(Card);
    }
    @Override
    public Ticket getTicket() {
        return ticket;
    }
}
