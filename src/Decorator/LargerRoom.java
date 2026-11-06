package Decorator;

public class LargerRoom extends BookingDecorator {

    public LargerRoom(BookingInter booking) {
        super(booking);
    }

    public double getPrice() {
        return booking.getPrice() + 100;
    }

    public String getDescription() {
        return booking.getDescription() + " + Spa Acess";
    }
}
