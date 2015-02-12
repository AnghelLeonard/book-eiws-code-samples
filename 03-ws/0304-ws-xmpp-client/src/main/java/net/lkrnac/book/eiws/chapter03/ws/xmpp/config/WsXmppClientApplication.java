package net.lkrnac.book.eiws.chapter03.ws.xmpp.config;

import javax.annotation.PostConstruct;

import net.lkrnac.book.eiws.chapter03.ws.xmpp.client.WebServiceClient;
import net.lkrnac.book.eiws.chapter03.ws.xmpp.client.WsXmppClientConfiguration;
import net.lkrnac.book.eiws.chapter03.ws.xmpp.model.UserDetailsResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WsXmppClientConfiguration.class)
public class WsXmppClientApplication {
  private static final Logger log = LoggerFactory
      .getLogger(WebServiceClient.class);

  public static void main(String[] args) {
    SpringApplication.run(WsXmppClientApplication.class, args);
  }

  @Autowired
  private WebServiceClient wsClient;

  @PostConstruct
  public void test() {
    UserDetailsResponse userDetails =
        wsClient.getUserDetails("lubos.krnac@gmail.com");
    log.info("User Details: " + userDetails.getFirstName() + " "
        + userDetails.getLastName());
  }
}
