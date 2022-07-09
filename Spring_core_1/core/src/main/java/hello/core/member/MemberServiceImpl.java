package hello.core.member;

public class MemberServiceImpl implements MemberService {
    // 관례상 구현체가 1개인 경우 ~Impl이라고 명명함.

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
