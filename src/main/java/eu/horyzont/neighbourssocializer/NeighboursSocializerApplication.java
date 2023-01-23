package eu.horyzont.neighbourssocializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class NeighboursSocializerApplication {

  public static void main(String[] args) {
    SpringApplication.run(NeighboursSocializerApplication.class, args);
  }

}
