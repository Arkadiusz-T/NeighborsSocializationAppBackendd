package eu.horyzont.neighbourssocializer.infrastructure.mongo.event;

import eu.horyzont.neighbourssocializer.domain.event.Event;
import eu.horyzont.neighbourssocializer.domain.event.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MongoEventRepository implements EventRepository {

    private final SpringMongoEventRepository repository;

    @Override
    public String insert(Event event) {
        return repository.insert(event).getId();
    }

    @Override
    public void update(String id, Event updatedEvent) {
        Event existingEvent = repository.findById(id)
            .orElseThrow(EventNotFoundException::new);
        existingEvent.updateFrom(updatedEvent);
        repository.save(existingEvent);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

}
