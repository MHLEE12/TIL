package mhspring.config.autoconfig;

import mhspring.config.ConditionalMyOnClass;
import mhspring.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Value("${contextPath:}")
    String contextPath;

    @Value("${port:8081}") // : 뒤에는 디폴트 값이 들어감. property값이 없는 경우 :의 오른쪽 값이 디폴트로 들어감.
    int port;

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean // 리턴 타입의 빈이 등록되어 있는지 확인하고 없다면 이것으로 빈 등록 한다.
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory(8086);

        factory.setContextPath(this.contextPath);
        factory.setPort(port);

        return factory;
    }
}
