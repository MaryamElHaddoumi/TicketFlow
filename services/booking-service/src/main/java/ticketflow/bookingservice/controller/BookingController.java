package ticketflow.bookingservice.controller;

import org.springframework.web.bind.annotation.*;
import ticketflow.bookingservice.dto.EventResponse;
import ticketflow.bookingservice.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/validate/{eventId}")
    public EventResponse validateEvent(@PathVariable Long eventId) {
        return bookingService.validateEvent(eventId);
    }
}
