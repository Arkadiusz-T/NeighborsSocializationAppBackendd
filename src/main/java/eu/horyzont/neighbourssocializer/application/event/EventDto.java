package eu.horyzont.neighbourssocializer.application.event;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDto {
    private double[] position;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
