package ticketflow.event_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import ticketflow.event_service.dto.EventResponse;

import java.util.Map;

@Service
public class EventService {

    private final Map<Long, EventResponse> events = Map.of(
            1L, new EventResponse(1L),
            2L, new EventResponse(2L)
    );

    public EventResponse get(Long id) {
        EventResponse event = events.get(id);

        if (event == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Event not found"
            );
        }

        return event;
    }
}