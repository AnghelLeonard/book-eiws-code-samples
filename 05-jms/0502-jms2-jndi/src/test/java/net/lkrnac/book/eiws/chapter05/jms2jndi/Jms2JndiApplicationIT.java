package net.lkrnac.book.eiws.chapter05.jms2jndi;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.naming.NamingException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Jms2JndiApplicationIT {
  private static final String MESSAGE_TEXT = "dummyMessage";

  @Test(groups = "maventests")
  public void queueTest() throws NamingException, JMSException {
    // GIVEN
    try (JmsConfiguration jmsConfiguration = new JmsConfiguration()) {
      jmsConfiguration.init();
      JMSContext jmsContext = jmsConfiguration.getJmsContext();
      Queue queue = jmsConfiguration.getQueue();

      // WHEN
      SimpleMessageSender messageSender = new SimpleMessageSender();
      messageSender.sendMessage(MESSAGE_TEXT);

      SimpleMessageReader messageConsumer = new SimpleMessageReader();
      messageConsumer.init(jmsContext, queue);
      String actualMessage = messageConsumer.readMessage();

      // THEN
      Assert.assertEquals(MESSAGE_TEXT, actualMessage);
    }
  }
}
