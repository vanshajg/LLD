package com.vanshajgirotra.designpatterns.factory.transport;

public class Plane implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by air");
    }
}
