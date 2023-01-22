package eu.horyzont.neighbourssocializer.query;

import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface SpringQueryEventRepository extends MongoRepository<EventReadModel, String> {

  List<EventReadModel> findByPositionNearAndDateTimeAfter(GeoJsonPoint location,
                                                          Distance distance,
                                                          LocalDate startDate);

  List<EventReadModel> findByPositionNearAndDateTimeBetween(GeoJsonPoint location,
                                                            Distance distance,
                                                            LocalDate startDate,
                                                            LocalDate endDate);

  List<EventReadModel> findByPositionNearAndCategoryEqualsAndDateTimeAfter(GeoJsonPoint location,
                                                                           Distance distance,
                                                                           String category,
                                                                           LocalDate startDate);

  List<EventReadModel> findByPositionNearAndDateTimeBetweenAndCategoryEquals(GeoJsonPoint location,
                                                                             Distance distance,
                                                                             LocalDate startDate,
                                                                             LocalDate endDate,
                                                                             String category);

}
