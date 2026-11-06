package Decorator;

public class Breakfast {
    public class Breakfast extends BookingDecorator {

    public Breakfast(Booking booking) {
        super(booking);
    }

    public double getPrice() {
        return booking.getPrice() + 40;
    }

    public String getDescription() {
        return booking.getDescription() + " + Extra breakfast";
    }
}
}
