package com.vanshajgirotra.multithreading.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReentrantReadWriteLockExample {
    @Getter()
    @Setter()
    int x = 0;

    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private void incX() {
        Lock lock = readWriteLock.writeLock();
        lock.lock();
        try {
            setX(getX() + 1);
            log.info("new x value, {}", getX());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        var example = new ReentrantReadWriteLockExample();
        Runnable task = () -> {
            for (int i = 0; i < 15; i++) {
                try {
                    Thread.sleep(random.nextInt(1000));
                    example.incX();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread2.start();
        thread1.start();

        try {
            thread2.join();
            thread1.join();
        } catch (Exception ignored) {
        }

        log.info("main exited");
    }
}
