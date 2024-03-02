package com.vanshajgirotra.multithreading;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadJoin {
    public static void main(String[] args) {
        log.info("Main thread is starting");
        Thread child = new Thread(() -> {
            for (int i = 0; i < 10000; i++) ;
            log.info("Child thread is done");
        }, "Child");
        child.start();
        try {
            // This will block the main thread until the child thread is done
            child.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Main thread is done");
    }
}
