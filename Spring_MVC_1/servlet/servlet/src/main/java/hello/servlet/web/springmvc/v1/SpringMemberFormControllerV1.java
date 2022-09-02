package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //이거 한개만 쓰던지 밑의 2개 annotation을 쓰면 된다.
//@Component // 컴포넌트 스캔을 통해 스프링 빈으로 등록 -> 이걸 안쓰고 ServletApplication.java에서 빈 등록을 직접 해줘도 된다.
//@RequestMapping
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }


}
