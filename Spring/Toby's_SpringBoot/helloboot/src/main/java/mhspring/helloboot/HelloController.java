package mhspring.helloboot;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

//@MyComponent
@RestController
public class HelloController {
    private final HelloService helloService;
    private final ApplicationContext applicationContext;

    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
        this.helloService = helloService;
        this.applicationContext = applicationContext;
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET) <- @GetMapping("/hello") 와 같은 의미
//    @ResponseBody // 이 어노테이션을 쓰지 않으면 반환되는 string을 view name으로 해석함. 클래스 단위로 @RestController 를 사용하면 어노테이션 생략 가능
    @GetMapping("/hello")
    public String hello(String name) {

        return helloService.sayHello(Objects.requireNonNull(name)); // null이면 예외를 던짐. null이 아니면 정상적으로 작동.
    }
}
