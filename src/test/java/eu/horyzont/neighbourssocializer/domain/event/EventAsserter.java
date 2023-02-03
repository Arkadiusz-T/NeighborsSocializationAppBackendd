package eu.horyzont.neighbourssocializer.domain.event;

import org.assertj.core.api.Assertions;

public class EventAsserter {

  private final Event actual;

  private EventAsserter(Event actual) {
    this.actual = actual;
  }

  public static EventAsserter assertThat(Event actual) {
    return new EventAsserter(actual);
  }

  public void isEqualTo(Event expected) {
    Assertions.assertThat(actual.getName()).isEqualTo(expected.getName());
    Assertions.assertThat(actual.getPosition()).isEqualTo(expected.getPosition());
    Assertions.assertThat(actual.getName()).isEqualTo(expected.getName());
    Assertions.assertThat(actual.getDateTime()).isEqualTo(expected.getDateTime());
    Assertions.assertThat(actual.getDuration()).isEqualTo(expected.getDuration());
    Assertions.assertThat(actual.getCategory()).isEqualTo(expected.getCategory());
    Assertions.assertThat(actual.getUser()).isEqualTo(expected.getUser());
    Assertions.assertThat(actual.getMinAge()).isEqualTo(expected.getMinAge());
    Assertions.assertThat(actual.getMaxAge()).isEqualTo(expected.getMaxAge());
    Assertions.assertThat(actual.getSex()).isEqualTo(expected.getSex());
  }
}
