package Booking;

public interface BookingState {
    void next(Booking booking);
    String getStatusName();
}