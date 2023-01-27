package eu.horyzont.neighbourssocializer.application;

import eu.horyzont.neighbourssocializer.domain.event.Event;
import eu.horyzont.neighbourssocializer.domain.event.EventRepository;
import eu.horyzont.neighbourssocializer.domain.user.AuthToken;
import eu.horyzont.neighbourssocializer.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventApplicationService {

  private final EventRepository eventRepository;
  private final AuthToken authToken;

  public String add(EventDto eventDto) {
    GeoJsonPoint position = new GeoJsonPoint(eventDto.getLongitude(), eventDto.getLatitude());
    User user = authToken.toUser();
    var event = new Event(
        position, eventDto.getName(), eventDto.getDateTime(), eventDto.getDuration(), eventDto.getCategory(), user,
        eventDto.getMinAge(), eventDto.getMaxAge(), eventDto.getSex());
    return eventRepository.insert(event);
  }

  public void deleteById(String id) {
    eventRepository.deleteById(id);
  }

  public void update(String id, EventDto eventDto) {
    GeoJsonPoint position = new GeoJsonPoint(eventDto.getLongitude(), eventDto.getLatitude());
    User user = authToken.toUser();
    var event = new Event(
        position, eventDto.getName(), eventDto.getDateTime(), eventDto.getDuration(), eventDto.getCategory(), user,
        eventDto.getMinAge(), eventDto.getMaxAge(), eventDto.getSex());
    eventRepository.update(id, event);
  }

}
