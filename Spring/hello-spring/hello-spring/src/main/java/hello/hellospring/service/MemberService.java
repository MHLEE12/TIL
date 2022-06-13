package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    // service class는 비즈니스와 가까운 용어를 사용해서 네이밍 함. 그래야 매칭 가능..
    // repository는 기계적으로 개발스러운 용어 사용한다..
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X

        // ifPresent는 result에 값이 있으면 동작함(optional로 감쌌기 때문에 가능)
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(member1 -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member); // 통과하면 저장
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
