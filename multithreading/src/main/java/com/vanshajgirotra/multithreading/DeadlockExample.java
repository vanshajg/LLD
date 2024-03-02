package com.vanshajgirotra.multithreading;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadlockExample {
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                log.info("Thread 1 acquired lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    log.info("Thread 1 acquired lock 2");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                log.info("Thread 2 acquired lock 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    log.info("Thread 2 acquired lock 1");
                }
            }
        });
        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) {
            log.info("Thread 1 status is {}", thread1.getState());
            log.info("Thread 2 status is {}", thread2.getState());
            Thread.sleep(100);
        }
    }
}
