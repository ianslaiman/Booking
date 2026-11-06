package Decorator;

public class RentACar extends BookingDecorator {

    public RentACar(BookingInter booking) {
        super(booking);
    }

    public double getPrice() {
        return booking.getPrice() + 300;
    }

    public String getDescription() {
        return booking.getDescription() + " + A car available at the landing airport";
    }
}

