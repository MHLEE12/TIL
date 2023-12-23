package mhspring.helloboot;

import mhspring.helloboot.config.EnableMyAutoConfiguration;
import mhspring.helloboot.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
@EnableMyAutoConfiguration
public class HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }
}
