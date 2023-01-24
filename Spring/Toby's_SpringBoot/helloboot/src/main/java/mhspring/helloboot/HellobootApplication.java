package mhspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HellobootApplication {

    public static void main(String[] args) {

//        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory(9000);
        // 톰캣 말고 다른 것을 사용한다면 ServletWebServerFactory를 사용

        // 서블릿 컨테이너를 생성하는 함수
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            // ServletContextInitializer 익명클래스를 람다식으로 바꿨음
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    resp.setStatus(200);
                    resp.setHeader("Content-Type", "text/plain");
                    resp.getWriter().println("Hello Servlet");
                }
            }).addMapping("/hello");
        });
        webServer.start(); // 톰캣 서블릿 컨테이너 실행
    }
}
