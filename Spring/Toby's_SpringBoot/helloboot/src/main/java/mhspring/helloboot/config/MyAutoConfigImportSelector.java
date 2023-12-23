package mhspring.helloboot.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "mhspring.helloboot.config.autoconfig.DispatcherServletConfig",
                "mhspring.helloboot.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
