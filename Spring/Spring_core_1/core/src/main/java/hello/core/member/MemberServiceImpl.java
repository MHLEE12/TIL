package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    // 관례상 구현체가 1개인 경우 ~Impl이라고 명명함.

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 추상화에만 의존하는 형태
    private final MemberRepository memberRepository;

    // 생성자를 통해서 객체가 들어가는 것 -> 생성자 주입
    // ComponentScan을 쓰면 Autowired도 쓰게 된다.
    @Autowired // ac.getBean(MemberRepository.class)가 자동으로 들어간다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
