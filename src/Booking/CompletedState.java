package Booking;

public class CompletedState implements BookingState {
    @Override
    public void next(Booking booking) {
        System.out.println("[State: COMPLETED] Booking is already fully processed. No further steps.");
    }

    @Override
    public String getStatusName() {
        return "COMPLETED";
    }
}