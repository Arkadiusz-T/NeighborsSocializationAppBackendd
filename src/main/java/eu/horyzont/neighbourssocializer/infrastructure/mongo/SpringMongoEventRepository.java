package eu.horyzont.neighbourssocializer.infrastructure.mongo;

import eu.horyzont.neighbourssocializer.domain.event.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

interface SpringMongoEventRepository extends MongoRepository<Event, String> {
}
