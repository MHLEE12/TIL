package com.wasPractice01;

import java.io.IOException;

// GET /calculate?operand1=10&operator=*&operand2=33
public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8091).start();
    }
}
