package hello.hellospring.service;

import hello.hellospring.domain.Member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 순수한 단위테스트가 훨씬 좋은 테스트일 확율이 높다. 스프링컨테이너 없이 테스트할 수 있도록 훈련하는 것이 좋다.

    @BeforeEach
    public void beforeEach() {
        // test실행시 각각 생성됨.(test는 독립적으로 실행해줘야 하니까!)
        // (MemberService클래스 입장에서 보면) MemberService에서 직접 new 하지 않고 외부에서 memberRepository를 넣어 주는 것
        // => Dependency Injection(의존성 주입, DI)
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
        // 실행때마다 끝나고 db의 값을 날려줌
    }

    @Test
    void 회원가입() {
        // test는 메소드명을 한글로 바꿔도 된다.

        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then(검증부)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        // memberService.join(member2)를 실행하면 IllegalStateException 이 예외가 터져야 한다는 것
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}