package com.vanshajgirotra.designpatterns.observer.publisher;


import com.vanshajgirotra.designpatterns.observer.subscriber.Subscriber;


/**
 * @param <T> The type of subscription
 * @param <Q> The return type of the subscription
 */
public interface Publisher<T, Q> {
    void subscribe(T subscriptionType, Subscriber<Q> subscriber);

    void unsubscribe(T subscriptionType, Subscriber<Q> subscriber);

    void notifySubscribers(T subscriptionType, Q newValue);

}
