package com.vanshajgirotra.designpatterns.factory.transport;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by road");
    }
}
