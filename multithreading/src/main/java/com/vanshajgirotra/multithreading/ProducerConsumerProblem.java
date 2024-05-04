package com.vanshajgirotra.multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class MessageQueue {
    final List<String> messages;
    final int limit;

    public MessageQueue(int limit) {
        this.limit = limit;
        this.messages = new LinkedList<>();
    }

    private boolean isFull() {
        return messages.size() == limit;
    }

    private boolean isEmpty() {
        return messages.isEmpty();
    }

    public synchronized void enqueue(final String message) {
        while (isFull()) {
            try {
                log.info("queue is full");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        messages.add(message);
        notifyAll();
    }

    public synchronized String dequeue() {
        while (isEmpty()) {
            try {
                log.info("queue is empty");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String message = messages.remove(0);
        notifyAll();
        return message;

    }
}

@Slf4j
public class ProducerConsumerProblem {


    public static void main(String[] args) {
        var queue = new MessageQueue(5);
        var blockingQueue = new ArrayBlockingQueue<String>(5);
        Random random = new Random();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                queue.enqueue(Character.getName(i + 67));
                try {
                    blockingQueue.put(Character.getName(i + 67));
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "producer");

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                String character = queue.dequeue();
                log.warn("*** character read: {} ***", character);
                try {
                    String read = blockingQueue.take();
                    log.warn("*** character read: {} ***", read);
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "consumer");

        producer.start();
        consumer.start();
    }
}
