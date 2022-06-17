package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean // 스프링 빈을 직접 등록하는 방법
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
