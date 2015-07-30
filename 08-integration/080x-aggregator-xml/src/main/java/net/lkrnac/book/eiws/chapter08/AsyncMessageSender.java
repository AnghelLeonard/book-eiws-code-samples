package net.lkrnac.book.eiws.chapter08;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncMessageSender {
  private SimpleService simpleService;

  @Autowired
  public AsyncMessageSender(SimpleService simpleService) {
    super();
    this.simpleService = simpleService;
  }

  @Async("customTaskExecutor")
  public void sendMessage(String message) throws Exception {
    Future<Boolean> resultFuture = simpleService.processText(message);
    boolean result = resultFuture.get(1, TimeUnit.SECONDS);
    log.info("Result for " + message + ": " + result);
  }
}
