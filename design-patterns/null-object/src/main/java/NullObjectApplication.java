import models.Vehicle;
import models.VehicleFactory;

public class NullObjectApplication {
    public static void main(String[] args) {

        // plane is not implemented yet
        Vehicle vehicle = VehicleFactory.getVehicle("plane");

        // this wouldn't throw a NullPointerException as vehicle is not null
        System.out.println("Vehicle wheels: " + vehicle.getWheels());
    }
}
