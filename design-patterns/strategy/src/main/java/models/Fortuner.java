package models;


import models.drive.LightDriver;

public class Fortuner extends Vehicle {
    public Fortuner() {
        super(new LightDriver());
    }
}
