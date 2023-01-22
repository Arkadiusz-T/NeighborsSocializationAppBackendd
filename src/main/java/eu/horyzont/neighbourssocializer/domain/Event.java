package eu.horyzont.neighbourssocializer.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document(collection = "event")
public class Event {

  @Id
  private String id;

  private GeoJsonPoint position;

  private String name;

  private LocalDateTime dateTime;

  private int duration;

  private String category;

  public Event(GeoJsonPoint position, String name, LocalDateTime dateTime, int duration, String category) {
    this.position = position;
    this.name = name;
    this.dateTime = dateTime;
    this.duration = duration;
    this.category = category;
  }

  public void updateFrom(Event other) {
    position = other.position;
    name = other.name;
    dateTime = other.dateTime;
    duration = other.duration;
    category = other.category;
  }

}
