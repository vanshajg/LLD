package models;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by road");
    }
}
