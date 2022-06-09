package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    // test코드는 다른데에서 가져다 쓸거 아니니 public 안써도 된다.

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

//      System.out.println("result = " + (result == member));
//      Assertions.assertEquals(member, result);
//      Assertions.assertEquals(member, null); // 에러난다.
        assertThat(member).isEqualTo(result);


    }

}
