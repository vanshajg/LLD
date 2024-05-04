package com.vanshajgirotra.multithreading;

import java.util.List;
import java.util.concurrent.Semaphore;

import lombok.RequiredArgsConstructor;

public class SemaphoreExample {
    public static void main(String[] args) {
        var sharedResource = new SharedResource();
        Thread thread1 = new Thread(new SharedResourceUser(sharedResource), "Thread 1");
        Thread thread2 = new Thread(new SharedResourceUser(sharedResource), "Thread 2");
        Thread threadMonitor = new Thread(new ThreadMonitor(List.of(thread1, thread2)), "Thread Monitor");

        thread1.start();
        thread2.start();
        threadMonitor.start();
    }
}

@RequiredArgsConstructor
class SharedResourceUser implements Runnable {
    private final SharedResource sharedResource;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.useSharedResource();
        }
    }
}

@RequiredArgsConstructor
class ThreadMonitor implements Runnable {
    private final List<Thread> threads;

    @Override
    public void run() {
        while (true) {
            for (Thread thread : threads) {
                System.out.println(thread.getName() + " is in state: " + thread.getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}

class SharedResource {
    // Create a semaphore with only one permit (i.e. only one thread can access the shared resource at a time)
    private final Semaphore semaphore = new Semaphore(1);
    private final String data = "Shared Resource";

    public void useSharedResource() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is using the shared resource: " + data);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

}
