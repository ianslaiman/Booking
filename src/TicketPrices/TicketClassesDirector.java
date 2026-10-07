package TicketPrices;

public class TicketClassesDirector 
{
    private TicketClassesBuilder builder;
    
    public TicketClassesDirector(TicketClassesBuilder builder)
    {
        this.builder = builder;
    }

    public void makeTicketClasses()
    {
        builder.buildEconomyPrice();
        builder.buildBusinessPrice();
        builder.buildFirstClassPrice();
        builder.buildVIPPrice();
        builder.buildPointsBonus();
        builder.buildChildBonus();
        builder.buildOverBaggingPenalty();
        builder.buildDisabilityBonus();
    }

    public TicketClasses getTicketClasses()
    {
        return builder.getTicketClasses();
    }
}
