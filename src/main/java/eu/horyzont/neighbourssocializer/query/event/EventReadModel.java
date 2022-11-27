package eu.horyzont.neighbourssocializer.query.event;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "event")
public class EventReadModel {

    @Id
    private String id;

    private double[] position;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
