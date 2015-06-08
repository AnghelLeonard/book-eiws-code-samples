package net.lkrnac.book.eiws.chapter06.text;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HandleDuplicatesApplication {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(HandleDuplicatesApplication.class, args);
  }
}
