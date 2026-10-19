package Facade;

import Profile.*;
import TicketFolder.*;
import TicketPrices.*;

public class BookingFacade {

    // 1. Profile Subsystem Integration
    public Profile setupUserProfile() {
        System.out.println("[Subsystem: Profile] Initializing user profile...");
        ProfileBuilder profileBuilder = new ProfileBuilder();
        profileBuilder.setFullName();
        profileBuilder.setEmail();
        profileBuilder.setPhoneNumber();
        profileBuilder.setAddress();
        profileBuilder.setDateOfBirth();
        profileBuilder.setGender();
        profileBuilder.setNationality();
        profileBuilder.setPassportNumber();

        Profile profile = profileBuilder.getProfile();
        System.out.println("   -> Profile created for: " + profile.getFullName() + " (" + profile.getEmail() + ")");
        return profile;
    }

    // 2. Ticket Subsystem Integration
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

    // 3. TicketPrices Subsystem Integration (Builder + Director)
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
    public void processBooking(String ticketCategory) {
        System.out.println("==========================================");
        System.out.println("       STARTING BOOKING PROCESS           ");
        System.out.println("==========================================");

        Profile profile = setupUserProfile();
        Ticket ticket = createBookingTicket(ticketCategory);
        TicketClasses prices = calculatePricing();

        System.out.println("------------------------------------------");
        System.out.println("SUCCESS: Booking complete for " + profile.getFullName());
        System.out.println("Type: " + ticket.toString() + " | Price object: " + prices.toString());
        System.out.println("==========================================\n");
    }
}