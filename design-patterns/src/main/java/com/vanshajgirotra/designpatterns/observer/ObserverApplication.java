package com.vanshajgirotra.designpatterns.observer;

import com.vanshajgirotra.designpatterns.observer.publisher.Publisher;
import com.vanshajgirotra.designpatterns.observer.publisher.StockPublisher;
import com.vanshajgirotra.designpatterns.observer.subscriber.GodaddyStockSubscriber;
import com.vanshajgirotra.designpatterns.observer.subscriber.GoogleStockSubscriber;

public class ObserverApplication {
    public static void main(String[] args) {

        Publisher<String, Integer> stockPublisher = new StockPublisher();
        stockPublisher.subscribe("GDDY", new GodaddyStockSubscriber());
        stockPublisher.subscribe("GOOGL", new GoogleStockSubscriber());
        stockPublisher.notifySubscribers("GDDY", 100);
        stockPublisher.notifySubscribers("GDDY", 120);
        stockPublisher.notifySubscribers("GOOGL", 1000);

    }

}
