package com.vanshajgirotra.multithreading;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterruptOddEvenThreads {
    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                log.info("val: {}", i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error("Thread interrupted: {}", Thread.currentThread().getName());
                    return;
                }
            }
        }, "odd thread");

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                log.info("val: {}", i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error("Thread interrupted: {}", Thread.currentThread().getName());
                    return;
                }
            }
        }, "even thread");

        Thread monitorThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                evenThread.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "thread monitor");

        oddThread.start();
        evenThread.start();
        monitorThread.start();

    }
}
