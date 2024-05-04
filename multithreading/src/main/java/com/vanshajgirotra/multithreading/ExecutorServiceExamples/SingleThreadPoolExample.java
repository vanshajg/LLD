package com.vanshajgirotra.multithreading.ExecutorServiceExamples;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService singleThreadpoolExecutorService = Executors.newSingleThreadExecutor();
        singleThreadpoolExecutorService.execute(SingleThreadPoolExample::countdown);
        singleThreadpoolExecutorService.shutdown();
    }

    static void countdown() {
        Random random = new Random();
        for (int i = 10; i >= 0; i--) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("{}", i);
        }
    }
}
