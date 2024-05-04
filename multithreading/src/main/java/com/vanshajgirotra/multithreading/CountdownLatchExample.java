package com.vanshajgirotra.multithreading;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
class Task implements Runnable {

    private final int taskIdx;
    private final CountDownLatch latch;
    final Random random = new Random();

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextInt(2000));
            log.info("task {} completed", taskIdx);
            latch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

@Slf4j
public class CountdownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Task(1, latch));
        executorService.submit(new Task(2, latch));
        executorService.submit(new Task(3, latch));
        executorService.submit(new Task(4, latch));
        executorService.submit(new Task(5, latch));
        latch.await();
        executorService.shutdown();
        log.info("all tasks completed");
    }
}
