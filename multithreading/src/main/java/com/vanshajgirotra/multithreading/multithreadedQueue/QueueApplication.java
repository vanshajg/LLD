package com.vanshajgirotra.multithreading.multithreadedQueue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueApplication {
    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(5);
        Thread thread1 = new Thread(() -> {
            int ctr = 10;
            while (ctr > 0) {
                try {
                    queue.enqueue(ctr);
                    log.info("Enqueued: " + ctr);
                    ctr--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            int ctr = 10;
            while (ctr > 0) {
                try {
                    log.info("Dequeued: " + queue.dequeue());
                    ctr--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
