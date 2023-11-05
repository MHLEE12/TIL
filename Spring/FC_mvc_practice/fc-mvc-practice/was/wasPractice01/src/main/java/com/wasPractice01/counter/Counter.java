package com.wasPractice01.counter;

public class Counter implements Runnable {
    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getValue() {
        return count;
    }

    @Override
    public void run() {
        // 상태를 유지하게 하는 코드
//        this.increment();
//        System.out.println("Value of Thread after increment " + Thread.currentThread().getName() + " " + this.getValue());
//        this.decrement();
//        System.out.println("Value of Thread at last " + Thread.currentThread().getName() + " " + this.getValue());

        // 상태를 유지하지 않게 해줌
        synchronized (this) {
            this.increment();
            System.out.println("Value of Thread after increment " + Thread.currentThread().getName() + " " + this.getValue());
            this.decrement();
            System.out.println("Value of Thread at last " + Thread.currentThread().getName() + " " + this.getValue());
        }
    }
}
