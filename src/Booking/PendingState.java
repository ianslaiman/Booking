package Booking;

public class PendingState implements BookingState {
    @Override
    public void next(Booking booking) {
        System.out.println("[State: PENDING] Payment received. Transitioning to PAID.");
        booking.setState(new PaidState());
    }

    @Override
    public String getStatusName() {
        return "PENDING";
    }
}