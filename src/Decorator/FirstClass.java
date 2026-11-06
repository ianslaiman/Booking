package Decorator;

public class FirstClass {
    public class FirstClass extends BookingDecorator {

    public FirstClass(Booking booking) {
        super(booking);
    }

    public double getPrice() {
        return booking.getPrice() + 100;
    }

    public String getDescription() {
        return booking.getDescription() + " + First Class";
    }
}
}
