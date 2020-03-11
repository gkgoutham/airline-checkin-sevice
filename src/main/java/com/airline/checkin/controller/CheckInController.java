package com.airline.checkin.controller;

import com.airline.checkin.model.Ticket;
import com.airline.checkin.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/webcheckin")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    @GetMapping("/ticket-info/{bookingId}/{lastName}")
    public ResponseEntity getTicketDetails(@PathVariable("bookingId") String bookingId, @PathVariable("lastName") String lastName) {
        System.out.println(bookingId + "========" + lastName);
        Optional<Ticket> ticket = checkInService.getTicketCheckInStatus(bookingId, lastName);
        if (ticket != null && ticket.isPresent()) {
            return new ResponseEntity("CheckIn is done for the given booking details", HttpStatus.FOUND);
        } else {
            ticket = checkInService.getTicketDetails(bookingId, lastName);
            if (ticket != null && ticket.isPresent()) {
                return new ResponseEntity<Ticket>(ticket.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity("No Ticket found for the given booking Details", HttpStatus.NOT_FOUND);
            }
        }
    }

    @GetMapping("/boarding-pass/{bookingId}/{lastName}")
    public ResponseEntity getBoardingPass(@PathVariable("bookingId") String bookingId, @PathVariable("lastName") String lastName) {
        System.out.println(bookingId + "========" + lastName);
        Optional<Ticket> ticket = checkInService.getTicketCheckInStatus(bookingId, lastName);
        if (ticket != null && ticket.isPresent()) {
            ticket = checkInService.getBoardingPass(bookingId, lastName);
            if (ticket != null && ticket.isPresent()) {
                return new ResponseEntity<Ticket>(ticket.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity("No Boarding Pass found for the given booking Details", HttpStatus.NOT_FOUND);
    }


    @PostMapping("/check-in/")
    public ResponseEntity checkinTicket(@RequestBody Ticket ticket) {
        Optional<Ticket> ticket1 = checkInService.saveCheckInDetails(ticket);
        if (ticket1.isPresent()) {
            return new ResponseEntity<Ticket>(ticket1.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity("No Ticket found for the given booking", HttpStatus.NOT_FOUND);
        }
    }
}
