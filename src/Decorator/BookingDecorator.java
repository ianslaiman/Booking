package Decorator;

public abstract class BookingDecorator implements BookingInter{
    protected BookingInter booking;

    public BookingDecorator(BookingInter booking) 
    {
        this.booking = booking;
    }
}
