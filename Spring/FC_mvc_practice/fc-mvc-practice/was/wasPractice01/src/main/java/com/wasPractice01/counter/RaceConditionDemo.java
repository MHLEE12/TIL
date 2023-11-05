package com.wasPractice01.counter;

public class RaceConditionDemo {
    // race condition : 여러 Thread가 하나의 자원에 동시에 접근하기 위해 경쟁하는 상태

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
