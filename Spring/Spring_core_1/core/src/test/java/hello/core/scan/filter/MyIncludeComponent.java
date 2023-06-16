package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // Type은 클래스 레벨에 붙는 것
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
    // 파일을 java class Annotation으로 만들기





}
