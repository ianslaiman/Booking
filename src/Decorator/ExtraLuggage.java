package Decorator;

public class ExtraLuggage extends BookingDecorator {

    public ExtraLuggage(BookingInter booking) {
        super(booking);
    }

    public double getPrice() {
        return booking.getPrice() + 40;
    }

    public String getDescription() {
        return booking.getDescription() + " + Extra luggage";
    }
}

