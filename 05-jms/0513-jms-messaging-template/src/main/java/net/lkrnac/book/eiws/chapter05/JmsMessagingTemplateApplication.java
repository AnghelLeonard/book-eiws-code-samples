package net.lkrnac.book.eiws.chapter05;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class JmsMessagingTemplateApplication {
  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(JmsMessagingTemplateApplication.class, args);
  }

  @Bean
  public UserWithRoleHandler userHandler() {
    return new UserWithRoleHandler() {
      @Override
      public void handleUser(User user, String role) {
        log.info("User object Received: {} with role {}", user, role);
      }
    };
  }
}
