package net.lkrnac.book.eiws.chapter02.httpinvoker.handlerservlet.javaconfig.server;

import net.lkrnac.book.eiws.chapter02.httpinvoker.handlerservlet.javaconfig.shared.BarService;

import org.springframework.stereotype.Service;

@Service
public class BarServiceImpl implements BarService {
  @Override
  public String serveBar(String param) {
    return "Bar service 0204 response to parameter: " + param;
  }
}
