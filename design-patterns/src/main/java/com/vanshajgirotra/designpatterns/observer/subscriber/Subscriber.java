package com.vanshajgirotra.designpatterns.observer.subscriber;

public interface Subscriber<T> {
    void update(T data);
}
