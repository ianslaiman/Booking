package Decorator;

public class ExtraLuggage {
    public class ExtraLuggage extends BookingDecorator {

    public ExtraLuggage(Booking booking) {
        super(booking);
    }

    public double getPrice() {
        return booking.getPrice() + 40;
    }

    public String getDescription() {
        return booking.getDescription() + " + Extra luggage";
    }
}
}
