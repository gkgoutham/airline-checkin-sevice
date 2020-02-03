package com.airline.checkin.controller;

import com.airline.checkin.model.Ticket;
import com.airline.checkin.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webcheckin")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    @GetMapping("/ticket-info/{bookingId}/{lastName}")
    public ResponseEntity<Ticket> getTicketDetails(@PathVariable("bookingId") String bookingId, @PathVariable("lastName") String lastName) {
        System.out.println(bookingId+"========"+lastName);
        return new ResponseEntity<Ticket>(checkInService.getTicketDetails(bookingId,lastName), HttpStatus.OK);
    }


}
