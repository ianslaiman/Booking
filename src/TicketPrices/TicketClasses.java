package TicketPrices;
public class TicketClasses {
    //Travel classes
    private int EconomyPrice;
    private int BusinessPrice;
    private int FirstClassPrice;
    private int VIPPrice;

    //Multipliers 
    private int PointsBonusPercent;
    private int ChildBonusPercent;
    private int OverBaggingPenaltyPercent;
    private int DisabilityBonusPercent;

    public int getEconomyPrice()
    {
        return EconomyPrice;
    }

    public int getBusinessPrice()
    {
        return BusinessPrice;
    }

    public int getFirstClassPrice()
    {
        return FirstClassPrice;
    }

    public int getVIPPrice()
    {
        return VIPPrice;
    }

    public int getPointsBonusPercent()
    {
        return PointsBonusPercent;
    }

    public int getChildBonusPercent()
    {
        return ChildBonusPercent;
    }

    public int getOverBaggingPenaltyPercent()
    {
        return OverBaggingPenaltyPercent;
    }

    public int getDisabilityBonusPercent()
    {
        return DisabilityBonusPercent;
    }

    public void setEconomyPrice(int EconomyPrice)
    {
        this.EconomyPrice = EconomyPrice;
    }   
    
    public void setBusinessPrice(int BusinessPrice)
    {
        this.BusinessPrice = BusinessPrice;
    }

    public void setFirstClassPrice(int FirstClassPrice)
    {
        this.FirstClassPrice = FirstClassPrice;
    }

    public void setVIPPrice(int VIPPrice)
    {
        this.VIPPrice = VIPPrice;
    }

    public void setPointsBonusPercent(int PointsBonusPercent)
    {
        this.PointsBonusPercent = PointsBonusPercent;
    }

    public void setChildBonusPercent(int ChildBonusPercent)
    {
        this.ChildBonusPercent = ChildBonusPercent;
    }

    public void setOverBaggingPenaltyPercent(int OverBaggingPenaltyPercent)
    {
        this.OverBaggingPenaltyPercent = OverBaggingPenaltyPercent;
    }

    public void setDisabilityBonusPercent(int DisabilityBonusPercent)
    {
        this.DisabilityBonusPercent = DisabilityBonusPercent;
    }

    @Override
    public String toString()
    {
        return "I am your price";
    }

}
