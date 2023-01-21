package eu.horyzont.neighbourssocializer.application;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDto {

  private double latitude;
  private double longitude;
  private String name;
  private LocalDateTime dateTime;
  private int duration;

}
