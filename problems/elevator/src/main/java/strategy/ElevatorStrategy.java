package strategy;

import java.util.List;

import models.Elevator;
import services.ElevatorService;

public interface ElevatorStrategy {
     ElevatorService getNextElevator(List<ElevatorService> elevators, int currentFloor, Elevator.Direction direction);

}
