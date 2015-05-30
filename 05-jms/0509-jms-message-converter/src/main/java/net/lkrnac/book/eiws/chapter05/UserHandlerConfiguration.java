package net.lkrnac.book.eiws.chapter05;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class UserHandlerConfiguration {
  @Bean
  public UserService userHandler() {
    return new UserService() {
      @Override
      public void processUser(User user) {
        log.info("User object Received: {}", user);
      }
    };
  }
}