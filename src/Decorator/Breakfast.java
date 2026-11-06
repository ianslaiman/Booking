package Decorator;

public class Breakfast extends BookingDecorator {

    public Breakfast(BookingInter booking) {
        super(booking);
    }

    @Override
    public double getPrice() {
        return booking.getPrice() + 50;
    }

    @Override
    public String getDescription() {
        return booking.getDescription() + " + Extra breakfast per person";
    }
}