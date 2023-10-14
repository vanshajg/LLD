package com.vanshajgirotra.designpatterns.strategy;

import com.vanshajgirotra.designpatterns.strategy.drive.LightDriver;

public class Fortuner extends Vehicle {
    public Fortuner() {
        super(new LightDriver());
    }
}
