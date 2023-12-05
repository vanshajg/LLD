package com.vanshajgirotra.designpatterns.observer.subscriber;

public class GoogleStockSubscriber implements Subscriber<Integer> {
    @Override
    public void update(Integer newValue) {
        System.out.println("Google Stock Subscriber received new value: " + newValue);
    }
}
