import models.Truck;
import models.Vehicle;

public class StrategyApplication {
    public static void main(String[] args) {
        Vehicle truck = new Truck();
        truck.drive();
    }
}
