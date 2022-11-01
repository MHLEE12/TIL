package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {

    // Servlet과 같은 모양의 인터페이스 생성
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
