package mhspring.helloboot;

import java.util.Objects;

public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    public String hello(String name) {

        return helloService.sayHello(Objects.requireNonNull(name)); // null이면 예외를 던짐. null이 아니면 정상적으로 작동.
    }

}
