package Decorator;

public class FlightBooking implements BookingInter {

    @Override
    public double getPrice() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Basic flight";
    }
}