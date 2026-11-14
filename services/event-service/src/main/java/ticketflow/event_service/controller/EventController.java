package ticketflow.event_service.controller;

import org.springframework.web.bind.annotation.*;
import ticketflow.event_service.dto.EventResponse;
import ticketflow.event_service.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public EventResponse get(@PathVariable Long id) {
        return service.get(id);
    }
}
