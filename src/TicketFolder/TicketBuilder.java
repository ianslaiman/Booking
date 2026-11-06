package TicketFolder;

public interface TicketBuilder {
    void buildTicketIdentifier(int identifier);
    void buildTicketPrice(int price);
    void buildTicketBrand(String brand);
    void buildTicketDate(String date);
    void buildTicketType(String type);
    void buildTicketDestination(String destination);
    void buildTicketOrigin(String origin);
    void buildTicketDocumentRequired(String document);
    void buildCreditCard(String card);
    Ticket getTicket();
}
