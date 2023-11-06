package com.servletPractice.newCalculate;

public class PositiveNumber {
    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        // value가 양수면 PositiveNumber 객체가 생성되고, 0 또는 음수이면 예외 터짐
        if(isNegativeNumber(value)) {
            throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt() {
        return value;
    }
}
