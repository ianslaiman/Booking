package TicketFolder;

public class TicketDemonstration {
    public static TicketFactory chooser(String type) {
        switch (type) {
            case "Transport":
                return new TransportTicketFactory();
            case "Hotel":
                return new HotelTicketFactory();
            default:
                return new HotelTicketFactory();
        }
    }
    public static void main(String[] args) {
        TicketFactory transportTicketFactory = chooser("Transport");
        Ticket transportTicket = transportTicketFactory.createTicket();
        System.out.println(transportTicket.toString());

        TicketFactory hotelTicketFactory = chooser("Hotel");
        Ticket hotelTicket = hotelTicketFactory.createTicket();
        System.out.println(hotelTicket.toString());
    }
}
