package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // @WebServlet
    // - name : 서블릿 이름
    // - urlPatterns : URL매핑
    // - name과 urlPatterns은 중복 있으면 안돼

    // 단축키 control+O
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain"); // content type - Header 정보에 들어감
        response.setCharacterEncoding("utf-8"); // content type - Header 정보에 들어감
        response.getWriter().write("hello " + username); // http message body에 데이터 들어감

    }

}
