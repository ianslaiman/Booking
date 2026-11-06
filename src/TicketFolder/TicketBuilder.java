package TicketFolder;

public interface TicketBuilder {
    void buildTicketIdentifier();
    void buildTicketPrice();
    void buildTicketBrand();
    void buildTicketDate();
    void buildTicketType();
    void buildTicketDestination();
    void buildTicketOrigin();
    void buildTicketDocumentRequired();
    void buildCreditCard();
    Ticket getTicket();
}
