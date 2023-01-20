package eu.horyzont.neighbourssocializer.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QueryEventRepository {

  private final SpringQueryEventRepository springQueryEventRepository;

  public List<EventReadModel> findAll() {
    return springQueryEventRepository.findAll();
  }

  public List<EventReadModel> searchEvents(SearchEventDto searchEventDto) {
    var center = new Point(searchEventDto.x(), searchEventDto.y());
    var distance = new Distance(searchEventDto.distanceInKilometers(), Metrics.KILOMETERS);
    return springQueryEventRepository.findByPositionNear(center, distance);
  }

}
