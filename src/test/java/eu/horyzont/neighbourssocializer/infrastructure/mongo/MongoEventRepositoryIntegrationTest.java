package eu.horyzont.neighbourssocializer.infrastructure.mongo;

import eu.horyzont.neighbourssocializer.domain.event.Event;
import eu.horyzont.neighbourssocializer.domain.event.EventAsserter;
import eu.horyzont.neighbourssocializer.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Testcontainers
class MongoEventRepositoryIntegrationTest {

  private static final double LONGITUDE = 16.982566;
  private static final double LATITUDE = 51.12788;
  private static final String NAME = "Nazwa Wydarzenia";
  private static final LocalDateTime DATE_TIME = LocalDateTime.of(2023, 12, 20, 15, 0);
  private static final int DURATION = 15;
  private static final String CATEGORY = "Rower";
  private static final User USER = new User("USERNAME", "FIRSTNAME");
  private static final int MIN_AGE = 20;
  private static final int MAX_AGE = 30;
  private static final String SEX = "Męska";

  @Container
  private static final MongoDBContainer mongoDbContainer = new MongoDBContainer(DockerImageName.parse("mongo:6.0.3"));

  @DynamicPropertySource
  static void setProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.data.mongodb.uri", mongoDbContainer::getReplicaSetUrl);
  }

  @Autowired
  private MongoEventRepository mongoEventRepository;

  @Autowired
  private MongoTemplate mongoTemplate;

  @Test
  void inserts_event() {
    // given
    Event event = givenEvent();

    // when
    String id = mongoEventRepository.insert(event);

    // then
    Event actual = mongoTemplate.findById(id, Event.class);
    EventAsserter.assertThat(actual).isEqualTo(event);
  }

  @Test
  void deletes_event() {
    // given
    Event event = givenEvent();
    String id = mongoEventRepository.insert(event);
    assertThat(mongoTemplate.findById(id, Event.class)).isNotNull();

    // when
    mongoEventRepository.deleteById(id);

    // then
    assertThat(mongoTemplate.findById(id, Event.class)).isNull();
  }

  private static Event givenEvent() {
    var geoJsonPoint = new GeoJsonPoint(LONGITUDE, LATITUDE);
    return new Event(geoJsonPoint, NAME, DATE_TIME, DURATION, CATEGORY, USER, MIN_AGE, MAX_AGE, SEX);
  }
}
