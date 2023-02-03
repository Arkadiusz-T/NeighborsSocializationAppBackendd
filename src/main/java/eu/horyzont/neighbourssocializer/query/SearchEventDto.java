package eu.horyzont.neighbourssocializer.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
class SearchEventDto {

  private final double latitude;
  private final double longitude;
  private final double distanceInMeters;
  private final LocalDate startDate;
  private final LocalDate endDate;
  private final String category;

  LocalDate getEndDate() {
    // add 1 day to include whole date in filtering
    return endDate.plusDays(1);
  }

  boolean areDatesNotEmpty() {
    return startDate != null && endDate != null;
  }

  boolean isCategoryNotEmpty() {
    return StringUtils.hasText(category);
  }

}
