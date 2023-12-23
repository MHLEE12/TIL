package mhspring.helloboot.config;

import mhspring.helloboot.config.autoconfig.DispatcherServletConfig;
import mhspring.helloboot.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class}) // 어노테이션의 메타 어노테이션으로 사용 가능
public @interface EnableMyAutoConfiguration {
}
