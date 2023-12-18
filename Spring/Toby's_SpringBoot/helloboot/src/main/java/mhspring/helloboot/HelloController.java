package mhspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET) <- @GetMapping("/hello") 와 같은 의미
    @GetMapping
    @ResponseBody // 이 어노테이션을 쓰지 않으면 반환되는 string을 view name으로 해석함. 클래스 단위로 @RestController 를 사용하면 어노테이션 생략 가능
    public String hello(String name) {

        return helloService.sayHello(Objects.requireNonNull(name)); // null이면 예외를 던짐. null이 아니면 정상적으로 작동.
    }

}
