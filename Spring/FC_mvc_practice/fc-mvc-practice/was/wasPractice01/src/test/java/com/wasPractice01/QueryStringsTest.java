package com.wasPractice01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {

    @Test
    void createTest() {
        QueryStrings queryStrings = new QueryStrings("operand1=10&operator=*&operand2=33"); // List<QueryString>

        assertThat(queryStrings).isNotNull();
    }
}
