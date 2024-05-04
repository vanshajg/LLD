package com.vanshajgirotra.multithreading;

public class PrintInOrder {
    static class Foo {
        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {
            printThird.run();
        }
    }

    public static void main(String[] args) {

        Foo foo = new Foo();
        Runnable printFirst = () -> System.out.println("First");
        Runnable printSecond = () -> System.out.println("Second");
        Runnable printThird = () -> System.out.println("Third");
        try {
            foo.first(printFirst);
            foo.second(printSecond);
            foo.third(printThird);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
