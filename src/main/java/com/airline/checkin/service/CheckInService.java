package com.airline.checkin.service;

import com.airline.checkin.model.Ticket;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CheckInService {


    private List<Ticket> ticketList = new ArrayList<>();

    public CheckInService() {
        Gson gson = new Gson();
        Ticket[] tickets = gson.fromJson(data, Ticket[].class);
        ticketList = Arrays.asList(tickets);
//        ticketList.stream().forEach(t -> {
//            System.out.println(t);
//            String bookingId = "686942";
//            String lastName = "Guzman";
//
//            System.out.println(!(t.isCheckIn()));
//            System.out.println((t.getBookingId().equals(bookingId)));
//            System.out.println((t.getEmail().equalsIgnoreCase(lastName)));
//            System.out.println(t.getLastName().equalsIgnoreCase(lastName));
//        });
    }

    public Optional<Ticket> saveCheckInDetails(Ticket ticket) {
        return  ticketList.stream().filter(t1 -> {
            Optional<Ticket> t2 = getTicketDetails(ticket.getBookingId(), ticket.getLastName());
            if ((t1.equals(t2.get()))) {
                return true;
            } else {
                return false;
            }
        }).map(ticket1 -> {
            ticket1.setCheckIn(true);
            ticket1.setPassengers(ticket1.getPassengers().stream().filter(passenger ->
                            ticket.getPassengers().stream().anyMatch(p -> {
                                if (p.getId() == passenger.getId())
                                    return true;
                                else
                                    return false;
                            })).collect(Collectors.toList()).stream().map(p -> {
                        p.setCheckIn(true);
                        return p;
                    }).collect(Collectors.toList())
            );
            return ticket1;
        }).map(Optional::ofNullable).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        CheckInService service = new CheckInService();
        Optional<Ticket> ticket = service.getTicketDetails("273869", "Monroe");
        if (ticket != null) {
            System.out.println(ticket.get());
        }
    }

    public Optional<Ticket> getTicketCheckInStatus(String bookingId, String lastName){
        return ticketList.stream().filter(t ->
                t.isCheckIn() && (t.getBookingId().equals(bookingId)) && (t.getEmail().equalsIgnoreCase(lastName) || t.getLastName().equalsIgnoreCase(lastName))
        ).map(Optional::ofNullable).findFirst().orElse(null);
    }

    public Optional<Ticket> getTicketDetails(String bookingId, String lastName) {
        return ticketList.stream().filter(t ->
                !(t.isCheckIn()) && (t.getBookingId().equals(bookingId)) && (t.getEmail().equalsIgnoreCase(lastName) || t.getLastName().equalsIgnoreCase(lastName))
        ).map(Optional::ofNullable).findFirst().orElse(null);
    }

    public Optional<Ticket> getBoardingPass(String bookingId, String lastName) {
        return ticketList.stream().filter(t ->
                (t.isCheckIn()) && (t.getBookingId().equals(bookingId)) && (t.getEmail().equalsIgnoreCase(lastName) || t.getLastName().equalsIgnoreCase(lastName))
        ).map(Optional::ofNullable).findFirst().orElse(null);
    }


    private String data = "[\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e3993a1b59c8ad80b9de19e\",\n" +
            "    \"bookingId\": 686942,\n" +
            "    \"checkIn\": false,\n" +
            "    \"price\": \"$1,009.63\",\n" +
            "    \"email\": \"mcbridemercer@viagrand.com\",\n" +
            "    \"phone\": \"+1 (854) 463-2305\",\n" +
            "    \"address\": \"807 Gelston Avenue, Needmore, District Of Columbia, 8678\",\n" +
            "    \"bookingDate\": \"2018-12-11T02:02:33 -06:-30\",\n" +
            "    \"travelingDate\": \"2018-08-15T10:09:49 -06:-30\",\n" +
            "    \"boardingLocation\": \"Guilford\",\n" +
            "    \"departureLocation\": \"Echo\",\n" +
            "    \"name\": \"Tyson\",\n" +
            "    \"lastName\": \"Guzman\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"id\": 8415,\n" +
            "        \"age\": 28,\n" +
            "        \"name\": \"Mattie\",\n" +
            "        \"lastName\": \"Craig\",\n" +
            "        \"gender\": \"female\",\n" +
            "        \"checkIn\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1562,\n" +
            "        \"age\": 24,\n" +
            "        \"name\": \"Sheree\",\n" +
            "        \"lastName\": \"Bryan\",\n" +
            "        \"gender\": \"female\",\n" +
            "        \"checkIn\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e3993a12a69bec05bfddf86\",\n" +
            "    \"bookingId\": 273869,\n" +
            "    \"checkIn\": false,\n" +
            "    \"price\": \"$3,079.18\",\n" +
            "    \"email\": \"shereebryan@viagrand.com\",\n" +
            "    \"phone\": \"+1 (989) 568-2350\",\n" +
            "    \"address\": \"897 Lewis Place, Faywood, New Mexico, 3229\",\n" +
            "    \"bookingDate\": \"2018-03-01T06:52:45 -06:-30\",\n" +
            "    \"travelingDate\": \"2016-05-02T10:30:59 -06:-30\",\n" +
            "    \"boardingLocation\": \"Garberville\",\n" +
            "    \"departureLocation\": \"Gilgo\",\n" +
            "    \"name\": \"May\",\n" +
            "    \"lastName\": \"Monroe\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"id\": 4638,\n" +
            "        \"age\": 35,\n" +
            "        \"name\": \"Hardin\",\n" +
            "        \"lastName\": \"William\",\n" +
            "        \"gender\": \"male\",\n" +
            "        \"checkIn\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2755,\n" +
            "        \"age\": 29,\n" +
            "        \"name\": \"Kinney\",\n" +
            "        \"lastName\": \"Wolfe\",\n" +
            "        \"gender\": \"male\",\n" +
            "        \"checkIn\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e3993a160fa530cbacc8ff5\",\n" +
            "    \"bookingId\": 613799,\n" +
            "    \"checkIn\": false,\n" +
            "    \"price\": \"$3,300.64\",\n" +
            "    \"email\": \"kinneywolfe@viagrand.com\",\n" +
            "    \"phone\": \"+1 (826) 567-3308\",\n" +
            "    \"address\": \"117 Glendale Court, Roy, North Carolina, 651\",\n" +
            "    \"bookingDate\": \"2014-05-18T09:46:23 -06:-30\",\n" +
            "    \"travelingDate\": \"2019-11-15T01:23:13 -06:-30\",\n" +
            "    \"boardingLocation\": \"Mapletown\",\n" +
            "    \"departureLocation\": \"Ribera\",\n" +
            "    \"name\": \"Joyce\",\n" +
            "    \"lastName\": \"Lewis\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"id\": 3083,\n" +
            "        \"age\": 40,\n" +
            "        \"name\": \"King\",\n" +
            "        \"lastName\": \"Callahan\",\n" +
            "        \"gender\": \"male\",\n" +
            "        \"checkIn\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 7849,\n" +
            "        \"age\": 26,\n" +
            "        \"name\": \"Margaret\",\n" +
            "        \"lastName\": \"Little\",\n" +
            "        \"gender\": \"female\",\n" +
            "        \"checkIn\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 7109,\n" +
            "        \"age\": 20,\n" +
            "        \"name\": \"Macdonald\",\n" +
            "        \"lastName\": \"Benjamin\",\n" +
            "        \"gender\": \"male\",\n" +
            "        \"checkIn\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 3774,\n" +
            "        \"age\": 39,\n" +
            "        \"name\": \"Salinas\",\n" +
            "        \"lastName\": \"Hall\",\n" +
            "        \"gender\": \"male\",\n" +
            "        \"checkIn\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e3993a16f3dbe2cb9404699\",\n" +
            "    \"bookingId\": 535135,\n" +
            "    \"checkIn\": true,\n" +
            "    \"price\": \"$3,309.02\",\n" +
            "    \"email\": \"salinashall@viagrand.com\",\n" +
            "    \"phone\": \"+1 (969) 402-3693\",\n" +
            "    \"address\": \"399 Cyrus Avenue, Forestburg, Minnesota, 8568\",\n" +
            "    \"bookingDate\": \"2016-04-24T03:15:07 -06:-30\",\n" +
            "    \"travelingDate\": \"2018-07-10T06:53:49 -06:-30\",\n" +
            "    \"boardingLocation\": \"Dorneyville\",\n" +
            "    \"departureLocation\": \"Nogal\",\n" +
            "    \"name\": \"Kerry\",\n" +
            "    \"lastName\": \"Kelley\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"id\": 3996,\n" +
            "        \"age\": 35,\n" +
            "        \"name\": \"Amparo\",\n" +
            "        \"lastName\": \"Flores\",\n" +
            "        \"gender\": \"female\",\n" +
            "        \"checkIn\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2011,\n" +
            "        \"age\": 34,\n" +
            "        \"name\": \"Sherrie\",\n" +
            "        \"lastName\": \"Cobb\",\n" +
            "        \"gender\": \"female\",\n" +
            "        \"checkIn\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 7212,\n" +
            "        \"age\": 32,\n" +
            "        \"name\": \"Lakisha\",\n" +
            "        \"lastName\": \"Valentine\",\n" +
            "        \"gender\": \"female\",\n" +
            "        \"checkIn\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e3993a1de2a7b14d1da8d18\",\n" +
            "    \"bookingId\": 689849,\n" +
            "    \"checkIn\": true,\n" +
            "    \"price\": \"$3,983.26\",\n" +
            "    \"email\": \"lakishavalentine@viagrand.com\",\n" +
            "    \"phone\": \"+1 (844) 400-3358\",\n" +
            "    \"address\": \"373 Clermont Avenue, Grayhawk, Federated States Of Micronesia, 1795\",\n" +
            "    \"bookingDate\": \"2014-03-11T05:11:47 -06:-30\",\n" +
            "    \"travelingDate\": \"2015-08-03T01:16:12 -06:-30\",\n" +
            "    \"boardingLocation\": \"Villarreal\",\n" +
            "    \"departureLocation\": \"Hannasville\",\n" +
            "    \"name\": \"Herrera\",\n" +
            "    \"lastName\": \"Mckinney\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"id\": 5477,\n" +
            "        \"age\": 20,\n" +
            "        \"name\": \"Mays\",\n" +
            "        \"lastName\": \"Blake\",\n" +
            "        \"gender\": \"male\",\n" +
            "        \"checkIn\": false\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 9660,\n" +
            "        \"age\": 22,\n" +
            "        \"name\": \"Rose\",\n" +
            "        \"lastName\": \"Mcclure\",\n" +
            "        \"gender\": \"male\",\n" +
            "        \"checkIn\": false\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";


}
