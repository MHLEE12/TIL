package com.oopPractice02;

import com.oopPractice02.newCalculate.*;

import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmetiOperator = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmetiOperator.stream()
                .filter(arithmetiOperator -> arithmetiOperator.supports(operator))
                .map(arithmetiOperator -> arithmetiOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
