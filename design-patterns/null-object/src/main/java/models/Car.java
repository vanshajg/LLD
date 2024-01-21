package models;

public class Car implements Vehicle {
    @Override
    public void travel() {
        System.out.println("Car is traveling");
    }

    @Override
    public int getWheels() {
        return 4;
    }
}
