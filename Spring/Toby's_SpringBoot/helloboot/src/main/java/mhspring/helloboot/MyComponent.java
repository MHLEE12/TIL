package mhspring.helloboot;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 언제까지 유지될 것인가
@Target(ElementType.TYPE) // 적용대상 지정
@Component // meta annotation
public @interface MyComponent {
}
