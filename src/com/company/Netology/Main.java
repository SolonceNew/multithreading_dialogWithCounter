package com.company.Netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        final int countThreadPool = 4;
        List<MyCallable> myCallableList = new ArrayList<>();

        System.out.println("Создаю потоки...");
        for (int i = 0; i <= countThreadPool; i++) {
            myCallableList.add(
                    new MyCallable(String.format("поток %d", i + 1))
            );
        }

        final ExecutorService threadPool = Executors.newFixedThreadPool(countThreadPool);

        try {
            List<Future<Integer>> futures = threadPool.invokeAll(myCallableList);
            for (int i = 0; i < futures.size(); i++) {
                System.out.println("Результат: " + futures.get(i).get());
            }
        } catch (InterruptedException | ExecutionException e) {

        }
        threadPool.shutdown();
    }
}
