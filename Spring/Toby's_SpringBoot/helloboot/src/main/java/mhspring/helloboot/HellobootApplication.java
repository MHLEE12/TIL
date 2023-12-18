package mhspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HellobootApplication {

    public static void main(String[] args) {
        // Spring Container
        GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
        applicationContext.registerBean(HelloController.class); // bean 등록
        applicationContext.registerBean(SimpleHelloService.class);
        applicationContext.refresh(); // 컨테이너를 초기화하여 가지고 있는 bean object 생성

//        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory(8081);
        // 톰캣 말고 다른 것을 사용한다면 ServletWebServerFactory를 사용

        // 서블릿 컨테이너를 생성하는 함수
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            // 서블릿 컨테이너에 서블릿 추가
            // ServletContextInitializer 익명클래스를 람다식으로 바꿨음

            servletContext.addServlet("dispatcherServlet",
                    // DispatcherServlet은 GenericWebApplicationContext타입의 컨테이너를 넘겨줘야함 사용해야함
                    new DispatcherServlet(applicationContext)
            ).addMapping("/*"); // 서블릿 컨테이너가 요청이 들어왔을때 어떤 서블릿과 연결할지 설정함(매핑)
        });
        webServer.start(); // 톰캣 서블릿 컨테이너 실행
    }
}
