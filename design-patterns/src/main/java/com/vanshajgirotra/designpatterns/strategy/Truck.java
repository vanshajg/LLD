package com.vanshajgirotra.designpatterns.strategy;

import com.vanshajgirotra.designpatterns.strategy.drive.HeavyDriver;

public class Truck extends Vehicle {
    public Truck() {
        super(new HeavyDriver());
    }
}
