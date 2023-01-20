package eu.horyzont.neighbourssocializer.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SearchEventDto {

  private final double x;
  private final double y;
  private final double distanceInKilometers;

}
