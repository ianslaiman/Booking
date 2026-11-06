package Decorator;

public class HotelBookingDec implements BookingInter{

    @Override
    public double getPrice()
    {
        return 250;
    }

    @Override
    public String getDescription()
    {
        return "Basic Hotel";
    }
}
