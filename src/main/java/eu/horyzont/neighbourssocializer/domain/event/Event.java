package eu.horyzont.neighbourssocializer.domain.event;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document(collection = "event")
public class Event {

    @Id
    private String id;

    private double[] position;

    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public Event(double[] position, String name, LocalDateTime startTime, LocalDateTime endTime) {
        this.position = position;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void updateFrom(Event other) {
        position = other.position;
        name = other.name;
        startTime = other.startTime;
        endTime = other.endTime;
    }

}
