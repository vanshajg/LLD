package models;

public class NullVehicle implements Vehicle {
    @Override
    public void travel() {
        System.out.println("NullVehicle is traveling");
    }

    @Override
    public int getWheels() {
        return 0;
    }
}
