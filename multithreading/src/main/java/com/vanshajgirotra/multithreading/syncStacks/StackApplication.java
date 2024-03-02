package com.vanshajgirotra.multithreading.syncStacks;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StackApplication {

    private static final Stack stack = new Stack(5);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            int ctr = 10;
            while (ctr-- >= 0) {
                stack.push(ctr);
            }
        });
        Thread thread2 = new Thread(() -> {
            int ctr = 10;
            while (ctr-- >= 0) {
                int val = stack.pop();
                log.info("popped: {}", val);
            }
        });

        thread1.start();
        thread2.start();

    }
}
