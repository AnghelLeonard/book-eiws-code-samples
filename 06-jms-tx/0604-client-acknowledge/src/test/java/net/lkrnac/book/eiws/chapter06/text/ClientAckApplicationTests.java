package net.lkrnac.book.eiws.chapter06.text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = ClientAckApplication.class)
public class ClientAckApplicationTests extends AbstractTestNGSpringContextTests {
  private static final String SELECT_COUNT =
      "select count(*) from TEXT_TABLE where text = ?";

  private static final String MESSAGE_TEXT = "simple message";
  private static final String MESSAGE_TEXT_DUPLICATE =
      "simple message duplicate";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  // (timeOut = 3000)
  public void testJms() throws InterruptedException {
    // GIVEN: Spring configuration

    // WHEN
    Thread.sleep(2000);

    // THEN
    long count =
        jdbcTemplate.queryForObject(SELECT_COUNT, Long.class, MESSAGE_TEXT);
    Assert.assertTrue(count > 0);

    long countDuplicate =
        jdbcTemplate.queryForObject(SELECT_COUNT, Long.class,
            MESSAGE_TEXT_DUPLICATE);
    Assert.assertTrue(countDuplicate > 1);
  }

}
