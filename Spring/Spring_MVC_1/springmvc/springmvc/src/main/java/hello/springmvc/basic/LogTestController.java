package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController // rest API 쓸때 쓰는 annotation
public class LogTestController {
//    @Slf4j 애노테이션이 있으면 밑의 코드가 자동으로 들어가져셔 그냥 log.~~ 쓸 수 있다.
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        // 실무에서는 로그를 사용해야 한다!

        String name = "Spring";
        // 이전 방법법
        System.out.println("name = " + name);

        // 문자가 합쳐지고 넘어간다. 이렇게 쓰면 안돼!
        log.trace("trace my log=" + name);

        // 출력 안된다. trace는 출력 안하는 것으로 application.properties에 설정했으니까!
        log.trace("trace log={}", name);

        // 로그 사용
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }

}
