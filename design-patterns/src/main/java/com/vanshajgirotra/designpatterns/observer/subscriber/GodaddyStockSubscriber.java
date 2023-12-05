package com.vanshajgirotra.designpatterns.observer.subscriber;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GodaddyStockSubscriber implements Subscriber<Integer> {

    @Override
    public void update(Integer newValue) {
      log.info("Received new value {} from the publisher", newValue);
    }
}
