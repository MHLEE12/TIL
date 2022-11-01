package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

// Test는 public 없어도 된다.
class MemberRepositoryTest {

    // test할 대상을 가져오는데 싱글톤이니 new하지 말고 가져온다.
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        // test가 끝나면 테스트 끝날때마다 초기화하기 위함
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given : ~가 주어졌을 때
        Member member = new Member("hello", 20);

        // when : ~를 실행했을 때
        Member savedMember = memberRepository.save(member);

        // then : 결과가 --이어야 해
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2); // result 안에 member1, member2가 들어있는지 확인

    }

}
