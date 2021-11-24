package com.company.Netology;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private final int sleepingTime = 3000;
    private final int step = 4;
    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try {
            while (count <= step) {
                Thread.sleep(sleepingTime);
                System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");
                count++;
            }
        } catch (InterruptedException e) {

        }
        return count;
    }

}
