package TicketFolder;

public class TransportTicket extends Ticket {
    private int TicketIdentifier;
    private int TicketPrice;
    private String TicketBrand;
    private String TicketDate;
    private String TicketType;
    private String TicketDestination;
    private String TicketOrigin;
    private String TicketDocumentRequired;

    public int getTicketIdentifier() {
        return TicketIdentifier;
    }
    public int getTicketPrice() {
        return TicketPrice;
    }
    public String getTicketBrand() {
        return TicketBrand;
    }
    public String getTicketDate() {
        return TicketDate;
    }
    public String getTicketType() {
        return TicketType;
    }
    public String getTicketDestination() {
        return TicketDestination;
    }
    public String getTicketOrigin() {
        return TicketOrigin;
    }
    public String getTicketDocumentRequired() {
        return TicketDocumentRequired;
    }
    public void setTicketIdentifier(int TicketIdentifier) {
        this.TicketIdentifier = TicketIdentifier;
    }
    public void setTicketPrice(int TicketPrice) {
        this.TicketPrice = TicketPrice;
    }
    public void setTicketBrand(String TicketBrand) {
        this.TicketBrand = TicketBrand;
    }
    public void setTicketDate(String TicketDate) {
        this.TicketDate = TicketDate;
    }
    public void setTicketType(String TicketType) {
        this.TicketType = TicketType;
    }
    public void setTicketDestintation(String TicketDestination) {
        this.TicketDestination = TicketDestination;
    }
    public void setTicketOrigin(String TicketOrigin) {
        this.TicketOrigin = TicketOrigin;
    }
    public void setTicketDocumentRequired(String TicketDocumentRequired) {
        this.TicketDocumentRequired = TicketDocumentRequired;
    }

    @Override 
    public String toString() {
        return "I am a Transport Ticket";
    }
}
