package com.vanshajgirotra.multithreading.shoeWarehouse;

public class ShoeWarehouseApplication {
    public static void main(String[] args) {
        var warehouse = new ShoeWarehouse();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                warehouse.receiveOrder(
                        new Order(
                                (int) (Math.random() * (10)),
                                "big",
                                10
                        ));
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                warehouse.fulfillOrder();
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                warehouse.fulfillOrder();
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
        consumer2.start();
    }
}
