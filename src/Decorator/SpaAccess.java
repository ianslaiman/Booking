package Decorator;

public class SpaAccess {
    public class SpaAccess extends BookingDecorator {

    public SpaAccess(Booking booking) {
        super(booking);
    }

    public double getPrice() {
        return booking.getPrice() + 40;
    }

    public String getDescription() {
        return booking.getDescription() + " + Spa Acess";
    }
}
}
