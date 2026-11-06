package Decorator;

public class HotelBooking implements Booking{
    public double getPrice()
    {
        return 250;
    }

    public String getInfo()
    {
        return "Basic Hotel";
    }
}
