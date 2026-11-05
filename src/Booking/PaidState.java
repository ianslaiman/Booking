package Booking;

public class PaidState implements BookingState {
    @Override
    public void next(Booking booking) {
        System.out.println("[State: PAID] Ticket issued. Transitioning to COMPLETED.");
        booking.setState(new CompletedState());
    }

    @Override
    public String getStatusName() {
        return "PAID";
    }
}