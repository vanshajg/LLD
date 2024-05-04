package com.vanshajgirotra.multithreading.multithreadedQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private final Queue<Integer> queue;
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void enqueue(int item) throws InterruptedException {
        // while loop because multiple threads can be waiting for the same condition
        while (queue.size() == capacity) {
            wait(); // thread(s) will start executing from here when notified
        }
        if (queue.isEmpty()) {
            notifyAll(); // notify all threads waiting for this condition
        }

        queue.add(item);
    }

    public synchronized int dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        if (queue.size() == capacity) {
            notifyAll();
        }
        return queue.remove();
    }

}
