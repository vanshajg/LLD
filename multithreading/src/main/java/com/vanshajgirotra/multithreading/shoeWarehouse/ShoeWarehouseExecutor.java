package com.vanshajgirotra.multithreading.shoeWarehouse;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShoeWarehouseExecutor {
    public static void main(String[] args) {
        ExecutorService producer = Executors.newSingleThreadExecutor();
        ShoeWarehouse shoeWarehouse = new ShoeWarehouse();
        Random random = new Random();
        producer.execute(() -> {
            for (int i = 0; i < 15; i++) {
                shoeWarehouse.receiveOrder(
                        Order.builder()
                                .orderId(i)
                                .shoeType("tasty")
                                .quantity(random.nextInt(500))
                                .build()
                );
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        producer.shutdown();
    }
}
