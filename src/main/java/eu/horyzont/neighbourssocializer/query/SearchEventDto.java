package eu.horyzont.neighbourssocializer.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SearchEventDto {

  private final double latitude;
  private final double longitude;
  private final double distanceInMeters;

}
