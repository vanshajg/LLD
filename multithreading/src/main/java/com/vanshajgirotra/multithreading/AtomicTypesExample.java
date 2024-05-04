package com.vanshajgirotra.multithreading;

import java.util.concurrent.Semaphore;

public class AtomicTypesExample {

    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(3);
        semaphore.acquire();
        semaphore.acquire();
        System.out.println(semaphore.availablePermits());
    }
}
