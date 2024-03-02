package com.vanshajgirotra.multithreading.syncStacks;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Stack {
    private final int[] stack;
    private int top;

    public Stack(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public synchronized void push(int value) {
        log.info("Thread {} is pushing {}", Thread.currentThread().getName(), value);
        if (isFull()) {
            log.info("Stack is full");
            return;
        }
        top++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        stack[top] = value;
    }

    public synchronized int pop() {
        log.info("Thread {} is popping", Thread.currentThread().getName());
        if (isEmpty()) {
            log.info("Stack is empty");
            return Integer.MIN_VALUE;
        }
        int val = stack[top];
        stack[top] = Integer.MIN_VALUE;
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        top--;
        return val;
    }
}
