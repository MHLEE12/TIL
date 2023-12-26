package mhspring.config.autoconfig;

import mhspring.config.ConditionalMyOnClass;
import mhspring.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean // 리턴 타입의 빈이 등록되어 있는지 확인하고 없다면 이것으로 빈 등록 한다.
    public ServletWebServerFactory servletWebServerFactory(Environment env) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory(8086);
//        factory.setContextPath("/app"); // http://localhost:8086/app/hello?name=Spring
        factory.setContextPath(env.getProperty("contextPath"));
        return factory;
    }
}
