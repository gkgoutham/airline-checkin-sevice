package com.airline.checkin.service;

import com.airline.checkin.model.Ticket;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CheckInService {

    private String data = "[\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e3798690ca869b4482e699d\",\n" +
            "    \"bookingId\": 160296,\n" +
            "    \"checkIn\": true,\n" +
            "    \"price\": \"$1,559.91\",\n" +
            "    \"email\": \"lorrieavila@supportal.com\",\n" +
            "    \"phone\": \"+1 (807) 486-3070\",\n" +
            "    \"address\": \"177 Dare Court, Whipholt, Oklahoma, 5251\",\n" +
            "    \"bookingDate\": \"2015-09-03T04:46:11 -06:-30\",\n" +
            "    \"travelingDate\": \"2017-11-07T03:12:23 -06:-30\",\n" +
            "    \"boardingLocation\": \"Wanamie\",\n" +
            "    \"departureLocation\": \"Villarreal\",\n" +
            "    \"name\": \"Taylor\",\n" +
            "    \"lastName\": \"Petersen\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"age\": 40,\n" +
            "        \"name\": \"Candy\",\n" +
            "        \"lastName\": \"Hunter\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 35,\n" +
            "        \"name\": \"Lily\",\n" +
            "        \"lastName\": \"Cotton\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 31,\n" +
            "        \"name\": \"Rosanna\",\n" +
            "        \"lastName\": \"Jensen\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 39,\n" +
            "        \"name\": \"Morrison\",\n" +
            "        \"lastName\": \"Mccray\",\n" +
            "        \"gender\": \"male\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 27,\n" +
            "        \"name\": \"Chandler\",\n" +
            "        \"lastName\": \"Sheppard\",\n" +
            "        \"gender\": \"male\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e37986960a2633815c247ce\",\n" +
            "    \"bookingId\": 859215,\n" +
            "    \"checkIn\": false,\n" +
            "    \"price\": \"$1,757.85\",\n" +
            "    \"email\": \"chandlersheppard@supportal.com\",\n" +
            "    \"phone\": \"+1 (915) 424-2968\",\n" +
            "    \"address\": \"780 Green Street, Southmont, Florida, 2685\",\n" +
            "    \"bookingDate\": \"2018-08-26T04:14:04 -06:-30\",\n" +
            "    \"travelingDate\": \"2015-08-21T12:36:04 -06:-30\",\n" +
            "    \"boardingLocation\": \"Westmoreland\",\n" +
            "    \"departureLocation\": \"Teasdale\",\n" +
            "    \"name\": \"Lowe\",\n" +
            "    \"lastName\": \"Hammond\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"age\": 25,\n" +
            "        \"name\": \"Diane\",\n" +
            "        \"lastName\": \"Meadows\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 30,\n" +
            "        \"name\": \"Clare\",\n" +
            "        \"lastName\": \"Delaney\",\n" +
            "        \"gender\": \"female\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e37986911baf2e240522abf\",\n" +
            "    \"bookingId\": 85268,\n" +
            "    \"checkIn\": false,\n" +
            "    \"price\": \"$3,388.79\",\n" +
            "    \"email\": \"claredelaney@supportal.com\",\n" +
            "    \"phone\": \"+1 (830) 533-2469\",\n" +
            "    \"address\": \"517 Columbia Street, Garnet, Federated States Of Micronesia, 5963\",\n" +
            "    \"bookingDate\": \"2019-10-22T01:30:54 -06:-30\",\n" +
            "    \"travelingDate\": \"2015-01-24T11:07:14 -06:-30\",\n" +
            "    \"boardingLocation\": \"Coalmont\",\n" +
            "    \"departureLocation\": \"Madaket\",\n" +
            "    \"name\": \"Beverley\",\n" +
            "    \"lastName\": \"Prince\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"age\": 35,\n" +
            "        \"name\": \"Janette\",\n" +
            "        \"lastName\": \"Rodgers\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 27,\n" +
            "        \"name\": \"Sherrie\",\n" +
            "        \"lastName\": \"Cabrera\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 24,\n" +
            "        \"name\": \"Vega\",\n" +
            "        \"lastName\": \"Velazquez\",\n" +
            "        \"gender\": \"male\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 29,\n" +
            "        \"name\": \"Raquel\",\n" +
            "        \"lastName\": \"Weaver\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 22,\n" +
            "        \"name\": \"Knowles\",\n" +
            "        \"lastName\": \"Hensley\",\n" +
            "        \"gender\": \"male\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e37986994c04ea00b60c3b9\",\n" +
            "    \"bookingId\": 313803,\n" +
            "    \"checkIn\": true,\n" +
            "    \"price\": \"$2,401.10\",\n" +
            "    \"email\": \"knowleshensley@supportal.com\",\n" +
            "    \"phone\": \"+1 (895) 490-3209\",\n" +
            "    \"address\": \"157 Milford Street, Marienthal, Utah, 2046\",\n" +
            "    \"bookingDate\": \"2019-07-01T02:21:09 -06:-30\",\n" +
            "    \"travelingDate\": \"2019-12-08T11:54:53 -06:-30\",\n" +
            "    \"boardingLocation\": \"Savage\",\n" +
            "    \"departureLocation\": \"Southview\",\n" +
            "    \"name\": \"Shirley\",\n" +
            "    \"lastName\": \"Roberts\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"age\": 22,\n" +
            "        \"name\": \"Trina\",\n" +
            "        \"lastName\": \"Clarke\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 29,\n" +
            "        \"name\": \"Carey\",\n" +
            "        \"lastName\": \"Jacobson\",\n" +
            "        \"gender\": \"male\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 27,\n" +
            "        \"name\": \"Glenna\",\n" +
            "        \"lastName\": \"Deleon\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 37,\n" +
            "        \"name\": \"Katharine\",\n" +
            "        \"lastName\": \"Camacho\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 31,\n" +
            "        \"name\": \"Macias\",\n" +
            "        \"lastName\": \"Murray\",\n" +
            "        \"gender\": \"male\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e379869584c34c382b50394\",\n" +
            "    \"bookingId\": 587760,\n" +
            "    \"checkIn\": false,\n" +
            "    \"price\": \"$2,180.75\",\n" +
            "    \"email\": \"maciasmurray@supportal.com\",\n" +
            "    \"phone\": \"+1 (945) 519-2402\",\n" +
            "    \"address\": \"280 Fleet Street, Hiseville, New York, 2754\",\n" +
            "    \"bookingDate\": \"2016-09-24T12:26:57 -06:-30\",\n" +
            "    \"travelingDate\": \"2019-08-14T02:16:22 -06:-30\",\n" +
            "    \"boardingLocation\": \"Babb\",\n" +
            "    \"departureLocation\": \"Vaughn\",\n" +
            "    \"name\": \"Lowery\",\n" +
            "    \"lastName\": \"Green\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"age\": 26,\n" +
            "        \"name\": \"Crane\",\n" +
            "        \"lastName\": \"Orr\",\n" +
            "        \"gender\": \"male\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 29,\n" +
            "        \"name\": \"Kramer\",\n" +
            "        \"lastName\": \"Raymond\",\n" +
            "        \"gender\": \"male\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e37986909b92687715396cb\",\n" +
            "    \"bookingId\": 640702,\n" +
            "    \"checkIn\": true,\n" +
            "    \"price\": \"$1,081.69\",\n" +
            "    \"email\": \"kramerraymond@supportal.com\",\n" +
            "    \"phone\": \"+1 (940) 428-2370\",\n" +
            "    \"address\": \"653 Temple Court, Walton, Louisiana, 1379\",\n" +
            "    \"bookingDate\": \"2019-07-11T12:43:37 -06:-30\",\n" +
            "    \"travelingDate\": \"2019-04-16T09:53:31 -06:-30\",\n" +
            "    \"boardingLocation\": \"Rivereno\",\n" +
            "    \"departureLocation\": \"Faxon\",\n" +
            "    \"name\": \"Yates\",\n" +
            "    \"lastName\": \"Hinton\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"age\": 25,\n" +
            "        \"name\": \"Milagros\",\n" +
            "        \"lastName\": \"Puckett\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 36,\n" +
            "        \"name\": \"Wilda\",\n" +
            "        \"lastName\": \"Burns\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 37,\n" +
            "        \"name\": \"Nina\",\n" +
            "        \"lastName\": \"Welch\",\n" +
            "        \"gender\": \"female\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"ticketNumber\": \"5e379869f19bf0093048bdd5\",\n" +
            "    \"bookingId\": 794363,\n" +
            "    \"checkIn\": false,\n" +
            "    \"price\": \"$2,578.95\",\n" +
            "    \"email\": \"ninawelch@supportal.com\",\n" +
            "    \"phone\": \"+1 (907) 457-3928\",\n" +
            "    \"address\": \"724 Wallabout Street, Kipp, Ohio, 4383\",\n" +
            "    \"bookingDate\": \"2019-04-29T01:11:53 -06:-30\",\n" +
            "    \"travelingDate\": \"2017-04-21T05:59:57 -06:-30\",\n" +
            "    \"boardingLocation\": \"Clayville\",\n" +
            "    \"departureLocation\": \"Yogaville\",\n" +
            "    \"name\": \"Wagner\",\n" +
            "    \"lastName\": \"Higgins\",\n" +
            "    \"passengers\": [\n" +
            "      {\n" +
            "        \"age\": 30,\n" +
            "        \"name\": \"Erin\",\n" +
            "        \"lastName\": \"Faulkner\",\n" +
            "        \"gender\": \"female\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 22,\n" +
            "        \"name\": \"Hamilton\",\n" +
            "        \"lastName\": \"Monroe\",\n" +
            "        \"gender\": \"male\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 29,\n" +
            "        \"name\": \"West\",\n" +
            "        \"lastName\": \"Roth\",\n" +
            "        \"gender\": \"male\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"age\": 37,\n" +
            "        \"name\": \"Sexton\",\n" +
            "        \"lastName\": \"Sanchez\",\n" +
            "        \"gender\": \"male\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";

    private List<Ticket> ticketList = new ArrayList<>();

    public CheckInService() {
        Gson gson = new Gson();
        Ticket[] tickets = gson.fromJson(data, Ticket[].class);
        ticketList = Arrays.asList(tickets);
        ticketList.stream().forEach(t->{
            System.out.println(t);
            String bookingId="794363";
            String lastName ="Higgins";

            System.out.println(!(t.isCheckIn()));
            System.out.println((t.getBookingId().equals(bookingId)));
            System.out.println((t.getEmail().equalsIgnoreCase(lastName)));
            System.out.println(t.getLastName().equalsIgnoreCase(lastName));
        });
    }

    public Ticket getTicketDetails(String bookingId, String lastName) {

        return ticketList.stream().filter(t ->
                !(t.isCheckIn()) && (t.getBookingId().equals(bookingId)) && (t.getEmail().equalsIgnoreCase(lastName) || t.getLastName().equalsIgnoreCase(lastName))
        ).findFirst().get();
    }

}
