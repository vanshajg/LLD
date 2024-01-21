package models;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null) {
            return new NullVehicle();
        }
        if (vehicleType.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (vehicleType.equalsIgnoreCase("Bike")) {
            return new Bike();
        }
        return new NullVehicle();
    }
}
