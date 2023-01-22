package eu.horyzont.neighbourssocializer.query;

import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface SpringQueryEventRepository extends MongoRepository<EventReadModel, String> {

  List<EventReadModel> findByPositionNear(GeoJsonPoint location, Distance distance);

  List<EventReadModel> findByPositionNearAndDateTimeBetween(GeoJsonPoint location,
                                                            Distance distance,
                                                            LocalDate startDate,
                                                            LocalDate endDate);

  List<EventReadModel> findByPositionNearAndCategoryEquals(GeoJsonPoint location, Distance distance, String category);

  List<EventReadModel> findByPositionNearAndDateTimeBetweenAndCategoryEquals(GeoJsonPoint location,
                                                                             Distance distance,
                                                                             LocalDate startDate,
                                                                             LocalDate endDate,
                                                                             String category);

}
