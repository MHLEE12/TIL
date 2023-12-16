package mhspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HellobootApplication {

    public static void main(String[] args) {

//        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory(8081);
        // 톰캣 말고 다른 것을 사용한다면 ServletWebServerFactory를 사용

        // 서블릿 컨테이너를 생성하는 함수
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            // 서블릿 컨테이너에 서블릿 추가
            // ServletContextInitializer 익명클래스를 람다식으로 바꿨음
            servletContext.addServlet("frontController", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    // 인증, 보안, 다국어, 공통 기능
                    if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        String name = req.getParameter("name");

                        resp.setStatus(HttpStatus.OK.value()); // 상태 코드 '200'
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE); // 헤더 설정
                        resp.getWriter().println("Hello " + name); // 바디 작성
                    } else if(req.getRequestURI().equals("/user")) {
                        //
                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value()); // 상태 코드 '404'
                    }
                }
            }).addMapping("/*"); // 서블릿 컨테이너가 요청이 들어왔을때 어떤 서블릿과 연결할지 설정함(매핑)
        });
        webServer.start(); // 톰캣 서블릿 컨테이너 실행
    }
}
