package eu.horyzont.neighbourssocializer.infrastructure.rest;

import eu.horyzont.neighbourssocializer.application.EventApplicationService;
import eu.horyzont.neighbourssocializer.application.EventDto;
import eu.horyzont.neighbourssocializer.query.EventReadModel;
import eu.horyzont.neighbourssocializer.query.QueryEventRepository;
import eu.horyzont.neighbourssocializer.query.SearchEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

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
  public List<EventReadModel> searchEvents(@RequestParam Double latitude,
                                           @RequestParam Double longitude,
                                           @RequestParam Double distanceInMeters,
                                           @RequestParam(required = false) @DateTimeFormat(iso = DATE) LocalDate startDate,
                                           @RequestParam(required = false) @DateTimeFormat(iso = DATE) LocalDate endDate,
                                           @RequestParam(required = false) String category) {
    var searchEventDto = new SearchEventDto(latitude, longitude, distanceInMeters, startDate, endDate, category);
    return queryEventRepository.searchEvents(searchEventDto);
  }

  @PostMapping
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<EventId> add(@RequestBody EventDto eventDto) {
    String id = eventApplicationService.add(eventDto);

    return new ResponseEntity<>(new EventId(id), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  @PreAuthorize("isAuthenticated()")
  public void update(@PathVariable String id, @RequestBody EventDto eventDto) {
    eventApplicationService.update(id, eventDto);
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("isAuthenticated()")
  public void delete(@PathVariable String id) {
    eventApplicationService.deleteById(id);
  }

}
