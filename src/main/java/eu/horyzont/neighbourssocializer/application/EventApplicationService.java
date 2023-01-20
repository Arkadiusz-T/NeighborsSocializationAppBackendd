package eu.horyzont.neighbourssocializer.application;

import eu.horyzont.neighbourssocializer.domain.Event;
import eu.horyzont.neighbourssocializer.domain.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventApplicationService {

  private final EventRepository eventRepository;

  public String add(EventDto eventDto) {
    var event = new Event(eventDto.getPosition(), eventDto.getName(), eventDto.getDateTime(), eventDto.getDuration());
    return eventRepository.insert(event);
  }

  public void deleteById(String id) {
    eventRepository.deleteById(id);
  }

  public void update(String id, EventDto eventDto) {
    var event = new Event(eventDto.getPosition(), eventDto.getName(), eventDto.getDateTime(), eventDto.getDuration());
    eventRepository.update(id, event);
  }

}
