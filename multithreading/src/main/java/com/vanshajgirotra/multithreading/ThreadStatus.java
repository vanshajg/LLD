package com.vanshajgirotra.multithreading;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadStatus {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i=0;i<10000;i++);
        }, "State");
        thread.start();
        while (thread.isAlive()) {
            log.info("Thread status is {}", thread.getState());
        }
    }
}
