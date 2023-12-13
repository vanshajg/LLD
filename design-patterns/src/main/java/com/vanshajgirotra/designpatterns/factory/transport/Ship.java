package com.vanshajgirotra.designpatterns.factory.transport;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea");
    }
}
