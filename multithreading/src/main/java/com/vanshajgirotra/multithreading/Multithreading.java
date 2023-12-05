package com.vanshajgirotra.multithreading;

public class Multithreading {
    public static void main(String[] args) {
        System.out.println("main thread running");
        // either overiding the run method in thread
        Thread thread1 = new Thread1();
        thread1.start();
        System.out.println("main method exit");
        /**
         * another method is passing in a runnable. This is the recommended method.
         * also as runnable is a functional interface we can send in a lambda as well.
         * shown below this.
         */
        Thread thread2 = new Thread(new Thread2());
        thread2.start();

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + " " + i);
            }
        });
        thread3.start();

    }
}
