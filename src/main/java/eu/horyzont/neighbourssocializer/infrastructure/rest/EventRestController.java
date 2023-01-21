package eu.horyzont.neighbourssocializer.infrastructure.rest;

import eu.horyzont.neighbourssocializer.application.EventApplicationService;
import eu.horyzont.neighbourssocializer.application.EventDto;
import eu.horyzont.neighbourssocializer.query.EventReadModel;
import eu.horyzont.neighbourssocializer.query.QueryEventRepository;
import eu.horyzont.neighbourssocializer.query.SearchEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
@CrossOrigin
public class EventRestController {
  private final EventApplicationService eventApplicationService;
  private final QueryEventRepository queryEventRepository;

  @GetMapping
  public List<EventReadModel> findAll() {
    return queryEventRepository.findAll();
  }

  @GetMapping("/search")
  public List<EventReadModel> searchEvents(@RequestParam Double latitude, @RequestParam Double longitude,
                                           @RequestParam Double distanceInMeters) {
    var searchEventDto = new SearchEventDto(latitude, longitude, distanceInMeters);
    return queryEventRepository.searchEvents(searchEventDto);
  }

  @PostMapping
  public ResponseEntity<EventId> add(@RequestBody EventDto eventDto) {
    String id = eventApplicationService.add(eventDto);

    return new ResponseEntity<>(new EventId(id), HttpStatus.CREATED);
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
