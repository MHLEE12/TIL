package mhspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

public class HellobootApplication {

    public static void main(String[] args) {

//        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory(9000);
        // 톰캣 말고 다른 것을 사용한다면 ServletWebServerFactory를 사용

        // 서블릿 컨테이너를 생성하는 함수
        WebServer webServer = serverFactory.getWebServer();
        webServer.start(); // 톰캣 서블릿 컨테이너 실행
    }
}
