package eu.horyzont.neighbourssocializer.query.event;

import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SpringQueryEventRepository extends MongoRepository<EventReadModel, String> {

    List<EventReadModel> findByPositionWithin(Circle circle);

    List<EventReadModel> findByPositionWithin(Box box);

}
