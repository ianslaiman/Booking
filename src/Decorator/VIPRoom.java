package Decorator;

public class VIPRoom extends BookingDecorator {

    public VIPRoom(BookingInter booking) {
        super(booking);
    }

    public double getPrice() {
        return booking.getPrice() + 300;
    }

    public String getDescription() {
        return booking.getDescription() + " + VIP room";
    }
}
