package net.lkrnac.book.eiws.chapter05;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class JmsMessageCreatorApplication {
  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(JmsMessageCreatorApplication.class, args);
  }

  @Bean
  public SimpleService simpleMessageHandler() {
    return new SimpleService() {
      @Override
      public void processText(String message) {
        log.info("Message Received: {}", message);
      }
    };
  }
}
