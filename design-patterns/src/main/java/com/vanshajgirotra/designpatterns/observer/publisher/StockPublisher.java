package com.vanshajgirotra.designpatterns.observer.publisher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vanshajgirotra.designpatterns.observer.subscriber.Subscriber;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StockPublisher implements Publisher<String, Integer> {

    private final Map<String, List<Subscriber<Integer>>> subscribers = new HashMap<>();


    @Override
    public void subscribe(String subscriptionType, Subscriber<Integer> subscriber) {
        if (!subscribers.containsKey(subscriptionType)) {
            subscribers.put(subscriptionType, List.of(subscriber));
        } else {
            subscribers.get(subscriptionType).add(subscriber);
        }
    }

    @Override
    public void unsubscribe(String subscriptionType, Subscriber<Integer> subscriber) {
        if (subscribers.containsKey(subscriptionType)) {
            subscribers.get(subscriptionType).remove(subscriber);
        }
    }

    @Override
    public void notifySubscribers(String subscriptionType, Integer newValue) {
        if (subscribers.containsKey(subscriptionType)) {
            subscribers.get(subscriptionType).forEach(subscriber -> {
                log.info("Notifying subscriber {} with new value {}", subscriber, newValue);
                subscriber.update(newValue);
            });
        }
    }
}
