package models;

public class Bike implements Vehicle {
    @Override
    public void travel() {
        System.out.println("Bike is traveling");
    }

    @Override
    public int getWheels() {
        return 2;
    }
}
