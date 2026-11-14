package ticketflow.bookingservice.service;

import org.springframework.stereotype.Service;
import ticketflow.bookingservice.client.EventClient;
import ticketflow.bookingservice.dto.EventResponse;

@Service
public class BookingService {

    private final EventClient eventClient;

    public BookingService(EventClient eventClient) {
        this.eventClient = eventClient;
    }

    public EventResponse validateEvent(Long eventId) {
        return eventClient.getById(eventId);
    }
}
