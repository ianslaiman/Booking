package TicketPrices;

public class TravellingBonusesBuilder implements TicketClassesBuilder{
    private TicketClasses ticketclasses;
    public TravellingBonusesBuilder()
    {
        this.ticketclasses = new TicketClasses();
    }

    @Override 
    public void buildEconomyPrice()
    {
        ticketclasses.setEconomyPrice(100);
    }

    @Override
    public void buildBusinessPrice()
    {
        ticketclasses.setBusinessPrice(250);
    }

    @Override
    public void buildFirstClassPrice()
    {
        ticketclasses.setFirstClassPrice(350);
    }

    @Override
    public void buildVIPPrice()
    {
        ticketclasses.setVIPPrice(500);
    }

    @Override
    public void buildPointsBonus()
    {
        ticketclasses.setPointsBonusPercent(10);
    }

    @Override
    public void buildChildBonus()
    {
        ticketclasses.setChildBonusPercent(20);
    }

    @Override
    public void buildOverBaggingPenalty()
    {
        ticketclasses.setOverBaggingPenaltyPercent(10);
    }

    @Override
    public void buildDisabilityBonus()
    {
        ticketclasses.setDisabilityBonusPercent(25);
    }

    @Override 
    public TicketClasses getTicketClasses()
    {
        return this.ticketclasses;
    }
}
