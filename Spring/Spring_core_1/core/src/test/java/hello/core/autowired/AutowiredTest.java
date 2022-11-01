package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }
    
    static class TestBean {

        @Autowired(required = false)
        public void  serNoBean1(Member noBean1) {

            // (required = false) : 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안된다!
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void  serNoBean2(@Nullable Member noBean2) {
            // @Nullable : 호출은 되는데 null이 나옴
            System.out.println("noBean2 = " + noBean2);
            // 결과 : noBean2 = null
        }



        @Autowired
        public void serNoBean3(Optional<Member> noBean3) {

            System.out.println("noBean3 = " + noBean3);
            // 결과 : noBean3 = Optional.empty
        }

    }
}
