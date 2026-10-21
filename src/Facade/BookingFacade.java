package Facade;

import Profile.*;
import TicketFolder.*;
import TicketPrices.*;

public class BookingFacade {

    // Ticket Integration
    public Ticket createBookingTicket(String ticketCategory) {
        System.out.println("[Subsystem: TicketFolder] Generating ticket...");
        TicketFactory ticketFactory;

        if ("Transport".equalsIgnoreCase(ticketCategory)) {
            ticketFactory = new TransportTicketFactory();
        } else {
            ticketFactory = new HotelTicketFactory();
        }

        Ticket ticket = ticketFactory.createTicket();
        System.out.println("   -> Ticket generated: " + ticket.toString());
        return ticket;
    }

    // 3. TicketPrices Integration (Builder + Director)
    public TicketClasses calculatePricing() {
        System.out.println("[Subsystem: TicketPrices] Building price and bonus structure...");
        TicketClassesBuilder builder = new TravellingBonusesBuilder();
        TicketClassesDirector director = new TicketClassesDirector(builder);

        director.makeTicketClasses();
        TicketClasses prices = director.getTicketClasses();

        System.out.println("   -> Base Economy Price: $" + prices.getEconomyPrice());
        System.out.println("   -> Applicable Points Bonus: " + prices.getPointsBonusPercent() + "%");
        return prices;
    }

    // Facade Operation
    public void processBooking(Profile profile,String ticketCategory) {
        System.out.println("==========================================");
        System.out.println("       STARTING BOOKING PROCESS           ");
        System.out.println("==========================================");

        Ticket ticket = createBookingTicket(ticketCategory);
        TicketClasses prices = calculatePricing();

        System.out.println("------------------------------------------");
        System.out.println("SUCCESS: Booking complete for " + profile.getFullName());
        System.out.println("Type: " + ticket.toString() + " | Price object: " + prices.toString());
        System.out.println("==========================================\n");
    }
}