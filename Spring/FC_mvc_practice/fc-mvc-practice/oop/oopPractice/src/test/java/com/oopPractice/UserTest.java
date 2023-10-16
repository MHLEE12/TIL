package com.oopPractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() {
        // given
        User user = new User();

        // when
        //user.initPassword(new CorrectFixedPasswordGenerator());
        // @FunctionalInterface 이면 아래와 같은 코드를 사용해도 됨.
        // 그러면 CorrectFixedPasswordGenerator같은 구현체를 만들지 않아도 됨
        user.initPassword(() -> "abcdefgh");

        // then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        // given
        User user = new User();

        // when
        user.initPassword(() -> "ab");

        // then
        assertThat(user.getPassword()).isNull();
    }
}