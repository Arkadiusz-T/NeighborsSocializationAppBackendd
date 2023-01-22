package eu.horyzont.neighbourssocializer.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QueryEventRepository {

  private final SpringQueryEventRepository springQueryEventRepository;

  public List<EventReadModel> findAll() {
    return springQueryEventRepository.findAll();
  }

  public List<EventReadModel> searchEvents(SearchEventDto searchEventDto) {
    var center = new GeoJsonPoint(searchEventDto.getLongitude(), searchEventDto.getLatitude());
    var distance = new Distance(searchEventDto.getDistanceInMeters() / 1_000, Metrics.KILOMETERS);
    if (searchEventDto.areDatesNotEmpty() && searchEventDto.isCategoryNotEmpty()) {
      return springQueryEventRepository.findByPositionNearAndDateTimeBetweenAndCategoryEquals(
          center, distance, searchEventDto.getStartDate(), searchEventDto.getEndDate(), searchEventDto.getCategory());
    }
    if (searchEventDto.areDatesNotEmpty()) {
      return springQueryEventRepository.findByPositionNearAndDateTimeBetween(
          center, distance, searchEventDto.getStartDate(), searchEventDto.getEndDate());
    }
    if (searchEventDto.isCategoryNotEmpty()) {
      return springQueryEventRepository.findByPositionNearAndCategoryEqualsAndDateTimeAfter(
          center, distance, searchEventDto.getCategory(), LocalDate.now());
    }
    return springQueryEventRepository.findByPositionNearAndDateTimeAfter(center, distance, LocalDate.now());
  }

}
