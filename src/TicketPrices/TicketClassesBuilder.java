package TicketPrices;

public interface TicketClassesBuilder {
    void buildEconomyPrice();
    void buildBusinessPrice();
    void buildFirstClassPrice();
    void buildVIPPrice();
    void buildPointsBonus();
    void buildChildBonus();
    void buildOverBaggingPenalty();
    void buildDisabilityBonus();
    TicketClasses getTicketClasses();
}
