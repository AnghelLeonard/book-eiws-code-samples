package net.lkrnac.book.eiws.chapter03.ws.interceptor.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurationSupport;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

@EnableWs
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ServerConfiguration extends WsConfigurationSupport {
  public static final String NAMESPACE =
      "http://localhost:10305/0305-ws-interceptor-service";

  private UserInterceptor userInterceptor;
  private GlobalIntercetor globalInterceptor;

  @Autowired
  public ServerConfiguration(UserInterceptor userInterceptor,
      GlobalIntercetor globalInterceptor) {
    super();
    this.userInterceptor = userInterceptor;
    this.globalInterceptor = globalInterceptor;
  }

  @Bean
  public SimpleWsdl11Definition userDetails() {
    return new SimpleWsdl11Definition(new ClassPathResource("userDetails.wsdl"));
  }

  @Bean
  public ServletRegistrationBean dispatcherServlet(
      ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(servlet, "/*");
  }

  @Override
  public void addInterceptors(List<EndpointInterceptor> interceptors) {
    interceptors.add(globalInterceptor);
    interceptors.add(userInterceptor);
  }
}
