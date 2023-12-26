package mhspring.helloboot;

import mhspring.config.EnableMyAutoConfiguration;
import mhspring.config.MySpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
@EnableMyAutoConfiguration
public class HellobootApplication {

    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        // System > Environment > Application
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println("my.name = " + name);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }
}
