package Decorator;

public class FlightBooking implements Booking{
    public double getPrice()
    {
        return 150;
    }

    public String getInfo()
    {
        return "Basic flight";
    }
}
