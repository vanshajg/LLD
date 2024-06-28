package models;

import models.drive.HeavyDriver;

public class Truck extends Vehicle {
    public Truck() {
        super(new HeavyDriver());
    }
}
