package eu.horyzont.neighbourssocializer.infrastructure.keycloak;

import eu.horyzont.neighbourssocializer.domain.user.AuthToken;
import eu.horyzont.neighbourssocializer.domain.user.User;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
class KeycloakAuthToken implements AuthToken {

  @Override
  public User toUser() {
    AccessToken accessToken = getAccessToken();
    return new User(accessToken.getPreferredUsername(), accessToken.getGivenName());
  }

  @SuppressWarnings("rawtypes")
  private AccessToken getAccessToken() {
    Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
    KeycloakPrincipal principal = (KeycloakPrincipal) auth.getPrincipal();
    KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
    return session.getToken();
  }
}
