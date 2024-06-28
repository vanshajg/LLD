import models.Plane;
import models.Ship;
import models.Transport;
import models.Truck;

public class TransportFactory {
    public static Transport buildTransport(String transportType) {
        return switch (transportType) {
            case "truck" -> new Truck();
            case "ship" -> new Ship();
            case "plane" -> new Plane();
            default -> throw new IllegalArgumentException("Invalid transport type");
        };
    }
}
