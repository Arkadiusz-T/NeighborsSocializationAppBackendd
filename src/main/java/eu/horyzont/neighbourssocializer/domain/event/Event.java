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

    private LocalDateTime dateTime;

    private int duration;

    public Event(double[] position, String name, LocalDateTime dateTime, int duration) {
        this.position = position;
        this.name = name;
        this.dateTime = dateTime;
        this.duration = duration;
    }

    public void updateFrom(Event other) {
        position = other.position;
        name = other.name;
        dateTime = other.dateTime;
        duration = other.duration;
    }

}
