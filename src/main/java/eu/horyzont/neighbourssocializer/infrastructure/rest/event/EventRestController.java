package eu.horyzont.neighbourssocializer.infrastructure.rest.event;

import eu.horyzont.neighbourssocializer.application.event.EventApplicationService;
import eu.horyzont.neighbourssocializer.application.event.EventDto;
import eu.horyzont.neighbourssocializer.query.event.EventReadModel;
import eu.horyzont.neighbourssocializer.query.event.QueryEventRepository;
import eu.horyzont.neighbourssocializer.query.event.SearchEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventRestController {

    private final EventApplicationService eventApplicationService;
    private final QueryEventRepository queryEventRepository;

    @GetMapping
    public List<EventReadModel> findAll() {
        return queryEventRepository.findAll();
    }

    @GetMapping("/search")
    public List<EventReadModel> searchEvents(@RequestParam Double x, @RequestParam Double y,
                                             @RequestParam Double radiusInKilometers) {
        var searchEventDto = new SearchEventDto(x, y, radiusInKilometers);
        return queryEventRepository.searchEvents(searchEventDto);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody EventDto eventDto) {
        String id = eventApplicationService.add(eventDto);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody EventDto eventDto) {
        eventApplicationService.update(id, eventDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        eventApplicationService.deleteById(id);
    }

}
