package mhspring.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE) // 이 테스트를 수행할 때는 웹환경을 세팅할 필요 없음을 알림
@Transactional
public class HelloRepositoryTest {
    @Autowired HelloRepository helloRepository;
    @Autowired JdbcTemplate jdbcTemplate;

    @Test
    void findHelloFailed() {
        assertThat(helloRepository.findHello("tody")).isNull();
    }

    @Test
    void increaseCount() {
        assertThat(helloRepository.countOf("Toby")).isEqualTo(0);

        helloRepository.increaseCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(1);

        helloRepository.increaseCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(2);

    }
}
