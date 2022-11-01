package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    // BeforeEach는 test를 실행하기 이전에 무조건 실행하는 것 표시(만약 테스트가 2개 있으면 2번 실행)
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void join() {
        //given - ~이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when - ~했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then - ~게 된다
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
