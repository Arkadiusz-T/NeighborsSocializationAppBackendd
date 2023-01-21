package eu.horyzont.neighbourssocializer.application;

import eu.horyzont.neighbourssocializer.domain.Event;
import eu.horyzont.neighbourssocializer.domain.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventApplicationService {

  private final EventRepository eventRepository;

  public String add(EventDto eventDto) {
    GeoJsonPoint position = new GeoJsonPoint(eventDto.getLongitude(), eventDto.getLatitude());
    var event = new Event(position, eventDto.getName(), eventDto.getDateTime(), eventDto.getDuration());
    return eventRepository.insert(event);
  }

  public void deleteById(String id) {
    eventRepository.deleteById(id);
  }

  public void update(String id, EventDto eventDto) {
    GeoJsonPoint position = new GeoJsonPoint(eventDto.getLongitude(), eventDto.getLatitude());
    var event = new Event(position, eventDto.getName(), eventDto.getDateTime(), eventDto.getDuration());
    eventRepository.update(id, event);
  }

}
