package eu.horyzont.neighbourssocializer.query;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SpringQueryEventRepository extends MongoRepository<EventReadModel, String> {

  List<EventReadModel> findByPositionNear(Point location, Distance distance);

}
