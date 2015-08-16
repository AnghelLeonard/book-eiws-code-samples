package net.lkrnac.book.eiws.chapter08.out;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class WriteRepositoryWithHeaders {
  public int writeWithHeader(String message, String simpleHeader) {
    log.info("Payload:" + message + "; Simple header:" + simpleHeader);
    return 1;
  }
}
