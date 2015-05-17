package net.lkrnac.book.eiws.chapter05;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class JmsMessageAnnotationsApplication {
  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(JmsMessageAnnotationsApplication.class, args);
  }

  @Bean
  public UserHandler userHandler() {
    return new UserHandler() {
      @Override
      public void handleUser(User user) {
        log.info("User object Received: {}", user);
      }
    };
  }
}
