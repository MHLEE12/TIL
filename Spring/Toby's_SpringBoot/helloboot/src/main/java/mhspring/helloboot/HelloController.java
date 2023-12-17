package mhspring.helloboot;

import java.util.Objects;

public class HelloController {

    public String hello(String name) {
        SimpleHelloService helloService = new SimpleHelloService();


        return helloService.sayHello(Objects.requireNonNull(name)); // null이면 예외를 던짐. null이 아니면 정상적으로 작동.
    }

}
