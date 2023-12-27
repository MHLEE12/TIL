package mhspring.config.autoconfig;

import mhspring.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import static java.lang.Integer.parseInt;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    @Bean
    public ServerProperties serverProperties(Environment env) {
        ServerProperties properties = new ServerProperties();

        properties.setContextPath(env.getProperty("contextPath"));
        properties.setPort(parseInt(env.getProperty("port")));

        return properties;
    }
}
