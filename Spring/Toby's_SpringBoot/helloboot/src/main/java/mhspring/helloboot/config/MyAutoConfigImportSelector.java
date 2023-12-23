package mhspring.helloboot.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> autoConfigs = new ArrayList<>();

//        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader); // 빈 클래스 가져올 때 classLoader 사용함
//        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);

        // 예시1
//        for(String candidate : ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
//            autoConfigs.add(candidate);
//        }
        // 예시2
//        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(candidate ->
//                autoConfigs.add(candidate)
//        );
        // 예시3
        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);
        // 어노테이션 클래스의 이름과 매칭되는 파일에서 목록을 읽어와서 String 배열로 만듦

//        return autoConfigs.stream().toArray(String[]::new); // 이런 식으로 사용 가능 1
//        return Arrays.copyOf(autoConfigs.toArray(), autoConfigs.size(), String[].class); // 이런 식으로 사용 가능 2
        return autoConfigs.toArray(new String[0]);
    }
}
