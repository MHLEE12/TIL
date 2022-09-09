package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 데이터 변경은 트랜젝션 안에서 이루어져야 함. (readOnly = true)는 읽기 전용(조회)
//@AllArgsConstructor // 생성자 만들어줌
@RequiredArgsConstructor // final이 있는 필드만 생성자를 만들어 줌
public class MemberService {

    // 필드 인젝션
//    @Autowired
//    private MemberRepository memberRepository;


//    private MemberRepository memberRepository;

    // setter 인젝션 : 운영 중간에 바꿀수 있다는 단점이 있다.
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    private final MemberRepository memberRepository;

    // 제일 좋은 방법은 생성자 인젝션 : 중간에 바뀌지 않는다.
    // 생성자가 1개만 있는 경우 @Autowired 생략가능
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /**
     * 회원 가입
     * @Transactional 여기서는 readOnly 옵션이 먹히면 안되는 것이라 따로 어노테이션 설정해준다.
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 멀티쓰레드 등의 상황을 고려해서 회원 이름을 유니크 제약조건 거는 것을 권장함
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * id로 회원 조회
     */
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
