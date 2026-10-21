package TicketPrices;

public class BonusShowcase {
    public static void main(String[] args) {
        TicketClassesBuilder exampleBuilder = new TravellingBonusesBuilder();

        TicketClassesDirector director1 = new TicketClassesDirector(exampleBuilder);

        director1.makeTicketClasses();

        TicketClasses ticketBuild = director1.getTicketClasses();

        System.out.println(ticketBuild);
    }
}
