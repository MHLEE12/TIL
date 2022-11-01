package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // Configuration annotation 붙은 것은 빈 등록에서 빼겠다는 것(이전에 수동으로 등록한 것이 있으므로 뺀 것!)
)
public class AutoAppConfig {



}
