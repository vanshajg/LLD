package com.vanshajgirotra.multithreading.creatingThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Multithreading {
    public static void main(String[] args) {
        /*
         * There are 2 ways to create a thread in java.
         * 1. extending the thread class
         * 2. implementing the runnable interface
         */

        log.info("main method entry");
        // Thread1 is a class that extends the Thread class.
        Thread thread1 = new Thread1();
        // async call to the run method of the thread1 object, returns immediately. scheduler will decide when to run this.
        thread1.start();

        /*
         * Thread2 is a class that implements the Runnable interface. This is the recommended way to create a thread.
         * This is because java does not support multiple inheritance and if we extend the thread class we cannot extend any other class.
         * also as runnable is a functional interface we can send in a lambda as well as shown with thread3
         */
        Thread thread2 = new Thread(new Thread2());
        thread2.start();

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + " " + i);
            }
        });

        thread3.start();
        log.info("main method exit");
    }
}
