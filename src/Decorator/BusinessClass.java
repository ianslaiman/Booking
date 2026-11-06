package Decorator;

public class BusinessClass {
    public class BusinessClass extends BookingDecorator {

        public BusinessClass(Booking booking) {
            super(booking);
        }

        public double getPrice() {
            return booking.getPrice() + 60;
        }

        public String getDescription() {
            return booking.getDescription() + " + BusinessClass";
        }
    }
}
