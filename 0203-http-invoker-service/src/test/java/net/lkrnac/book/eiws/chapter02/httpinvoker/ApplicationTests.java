package net.lkrnac.book.eiws.chapter02.httpinvoker;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests extends AbstractTestNGSpringContextTests {
  @Test
  public void contextLoads() {
  }
}
