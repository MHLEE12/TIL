package mhspring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // 이 오브젝트가 우선적으로 빈 주입함
public class HelloDecorator implements HelloService {

    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }

    @Override
    public int countOf(String name) {
        return helloService.countOf(name);
    }
}
