package com.vanshajgirotra.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {
        final CyclicBarrier barrier = new CyclicBarrier(2);
        Thread thread1 = new Thread(() -> {
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            log.info("thread1 starting now");
        });
        thread1.start();

        Thread.sleep(1000);

        Thread thread2 = new Thread(() -> {
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            log.info("thread2 starting now");
        });
        thread2.start();
    }
}
