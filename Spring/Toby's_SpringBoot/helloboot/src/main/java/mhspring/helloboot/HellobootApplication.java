package mhspring.helloboot;

import mhspring.config.EnableMyAutoConfiguration;
import mhspring.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
@EnableMyAutoConfiguration
public class HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }
}
