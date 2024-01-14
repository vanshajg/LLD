package models;

import java.util.ArrayList;
import java.util.List;

import models.product.Vehicle;

public class VehicleRepository {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public Vehicle getVehicleById(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId().equals(id)) {
                return vehicle;
            }
        }
        return null;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle getVehicle() {
        return vehicles.get(0);
    }

}
