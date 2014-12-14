package net.lkrnac.book.eiws.chapter02.rmi.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public final class Application {
  private Application() {
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
