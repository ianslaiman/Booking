package Decorator;

public class BookingDecorator implements Booking{
    protected Booking booking;

    public BookingDectorator(Booking booking) 
    {
        this.booking = booking;
    }
}
