import java.util.List;

import models.Elevator;
import services.ElevatorController;
import services.ElevatorService;
import strategy.NearestElevatorStrategy;

public class ElevatorApplication {
    public static void main(String[] args) {
        List<ElevatorService> elevators = List.of(
                new ElevatorService(1),
                new ElevatorService(2),
                new ElevatorService(3),
                new ElevatorService(4),
                new ElevatorService(5)
        );

        ElevatorController elevatorController = new ElevatorController(elevators, new NearestElevatorStrategy());
        elevatorController.floorButton(3, Elevator.Direction.UP);
        elevatorController.floorButton(5, Elevator.Direction.UP);
        elevatorController.floorButton(2, Elevator.Direction.UP);
        elevatorController.floorButton(1, Elevator.Direction.UP);
        elevatorController.floorButton(4, Elevator.Direction.DOWN);
        elevatorController.floorButton(1, Elevator.Direction.DOWN);

    }
}
