package eu.horyzont.neighbourssocializer.infrastructure.mongo;

import eu.horyzont.neighbourssocializer.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

interface SpringMongoEventRepository extends MongoRepository<Event, String> {
}
