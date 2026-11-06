package TicketFolder;

public class HotelTicketBuilder implements TicketBuilder {
    private Ticket ticket;

    public HotelTicketBuilder() {
        this.ticket = new HotelTicket();
    }

    @Override
    public void buildTicketIdentifier(int Identifer) {
        ticket.setTicketIdentifier(Identifer);
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
    public void buildTicketDestination(String destination) {
        ticket.setTicketDestination(destination);
    }
    @Override 
    public void buildTicketOrigin(String Origin) {
        ticket.setTicketOrigin(Origin);
    }
    @Override 
    public void buildTicketDocumentRequired(String document) {
        ticket.setTicketDocumentRequired(document);
    }
    @Override 
    public void buildCreditCard(String card){
        ticket.setCreditCard(card);
    }
    @Override 
    public Ticket getTicket() {
        return ticket;
    }
}
