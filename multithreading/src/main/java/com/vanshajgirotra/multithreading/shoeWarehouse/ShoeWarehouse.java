package com.vanshajgirotra.multithreading.shoeWarehouse;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShoeWarehouse {
    private static final int MAX_ORDERS = 10;
    private final Queue<Order> orders = new ArrayDeque<>();

    public ShoeWarehouse() {
        final ExecutorService orderFullFiller = Executors.newSingleThreadExecutor();
        Random random = new Random();
        orderFullFiller.execute(() -> {
            for (int i = 15; i > 0; i--) {
                fulfillOrder();
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        orderFullFiller.shutdown();
    }

    public synchronized void receiveOrder(Order order) {
        while (orders.size() == MAX_ORDERS) {
            try {
                log.info("shoe warehouse max capacity reached");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        notifyAll();
        log.info("received order: {}", order);
        orders.add(order);
    }

    public synchronized void fulfillOrder() {
        while (orders.isEmpty()) {
            try {
                log.info("shoe warehouse inventory empty");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Order order = orders.poll();
        log.info("fulfilling order: {}", order);
        notifyAll();
    }
}
