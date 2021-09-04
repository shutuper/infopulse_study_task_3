package com.company.mapper;

public class Test {

    public static void main(String[] args) {
        // (Порушна умову анотації)
        Flight flight = new Flight(new Flight.Person("Maria", "Tombson"), 12, "Paris", "Kyiv", 3800);

        Flight flight1 = new Flight(new Flight.Person("August", "Backer"), 14, "Kherson", "Lviv", 800);
        ModelMapper<Flight, TicketDTO> mapper = new ModelMapper<>();
        TicketDTO ticket = null;
        TicketDTO ticket1 = null;
        try {
            ticket1 = mapper.map(flight1, TicketDTO.class);
            ticket = mapper.map(flight, TicketDTO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(ticket + " " + ticket1);

    }
}
