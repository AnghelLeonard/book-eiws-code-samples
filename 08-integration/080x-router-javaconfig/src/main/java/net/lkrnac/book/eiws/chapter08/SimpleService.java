package net.lkrnac.book.eiws.chapter08;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface SimpleService {
  @Gateway(requestChannel = "inChannel")
  public boolean processText(String text);
}
