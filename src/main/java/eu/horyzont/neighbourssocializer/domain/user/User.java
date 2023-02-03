package eu.horyzont.neighbourssocializer.domain.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class User {

  private final String username;
  private final String firstname;

}
