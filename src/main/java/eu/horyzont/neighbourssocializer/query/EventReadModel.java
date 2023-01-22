package eu.horyzont.neighbourssocializer.query;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "event")
public class EventReadModel {

  @Id
  private String id;

  private GeoJsonPoint position;

  private String name;

  private LocalDateTime dateTime;

  private int duration;

  private String category;

}
