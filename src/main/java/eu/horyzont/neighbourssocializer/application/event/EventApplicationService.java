package eu.horyzont.neighbourssocializer.application.event;

import eu.horyzont.neighbourssocializer.domain.event.Event;
import eu.horyzont.neighbourssocializer.domain.event.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventApplicationService {

    private final EventRepository eventRepository;

    public String add(EventDto eventDto) {
        var event = new Event(eventDto.getPosition(), eventDto.getName(), eventDto.getStartTime(),
            eventDto.getEndTime());
        return eventRepository.insert(event);
    }

    public void deleteById(String id) {
        eventRepository.deleteById(id);
    }

    public void update(String id, EventDto eventDto) {
        var event = new Event(eventDto.getPosition(), eventDto.getName(), eventDto.getStartTime(),
            eventDto.getEndTime());
        eventRepository.update(id, event);
    }

}
