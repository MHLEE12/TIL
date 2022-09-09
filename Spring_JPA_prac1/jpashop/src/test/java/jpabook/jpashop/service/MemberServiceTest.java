package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class) // junit 실행시 spring과 같이 엮어서 실행할 때 쓰는 것
@SpringBootTest // spring boot를 띄운 상태로 테스트하기 위한 것. 없으면 @Autowired 안된다.
@Transactional // 이게 있어야 롤백이 된다.
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    @Rollback(false) // 이걸 해야 console에서 insert문 확인할 수 있다.
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("Lee");

        // when
        Long saveId = memberService.join(member);

        // then
//        em.flush();
        assertEquals(member, memberRepository.findOne(saveId));
//        Assertions.assertThat(member).isEqualTo(memberRepository.findOne(saveId));

    }

//    @Test(expected = IllegalStateException.class) // 이거 안된다ㅜㅜ
    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("Lee");

        Member member2 = new Member();
        member2.setName("Lee");

        // when
        memberService.join(member1);
        try {
            memberService.join(member2); // 예외가 발생해야 한다!!
        } catch (IllegalStateException e) {
            return; // 예외 터지면서 리턴되면 테스트 성공~
        }

        // then
        fail("예외가 발생해야 한다.");

    }

}