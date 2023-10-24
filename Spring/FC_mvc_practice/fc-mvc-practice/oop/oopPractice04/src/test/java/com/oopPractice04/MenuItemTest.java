package com.oopPractice04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuItemTest {

    @DisplayName("메뉴 항목을 생성한다.")
    @Test
    void createTest() {
        assertThatCode(() -> new MenuItem("떡볶이", 5000))
                .doesNotThrowAnyException();
    }
}
