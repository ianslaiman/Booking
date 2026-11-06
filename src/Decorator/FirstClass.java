package Decorator;

public class FirstClass extends BookingDecorator {

    public FirstClass(BookingInter booking) {
        super(booking);
    }

    public double getPrice() {
        return booking.getPrice() + 100;
    }

    public String getDescription() {
        return booking.getDescription() + " + First Class";
    }
}

