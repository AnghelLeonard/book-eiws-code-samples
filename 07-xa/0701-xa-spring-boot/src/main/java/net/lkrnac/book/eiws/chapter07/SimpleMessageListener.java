package net.lkrnac.book.eiws.chapter07;

import javax.jms.Session;

import net.lkrnac.book.eiws.chapter07.SimpleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageListener {
  private SimpleService simpleService;
  private boolean errorSimulated = false;

  @Autowired
  public SimpleMessageListener(SimpleService simpleService) {
    super();
    this.simpleService = simpleService;
  }

  @JmsListener(destination = "messageQueue")
  public void readMessage(String message, Session session) {
    simpleService.processText(message);
    postprocess(message);
  }

  private void postprocess(String message) {
    // simulate error
    if (!errorSimulated) {
      errorSimulated = true;
      throw new IllegalArgumentException(message);
    }
  }
}
