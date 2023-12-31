package mhspring.helloboot;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

//@MyComponent
@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET) <- @GetMapping("/hello") 와 같은 의미
//    @ResponseBody // 이 어노테이션을 쓰지 않으면 반환되는 string을 view name으로 해석함. 클래스 단위로 @RestController 를 사용하면 어노테이션 생략 가능
    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
    }

    @GetMapping("/count")
    public String count(String name) {
        return name + ": " + helloService.countOf(name);
    }
}
