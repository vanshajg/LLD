package strategy;

import java.util.List;

import models.Elevator;
import services.ElevatorService;

public class NearestElevatorStrategy implements ElevatorStrategy {

    @Override
    public ElevatorService getNextElevator(List<ElevatorService> elevators, int currentFloor, Elevator.Direction direction) {
        ElevatorService nearestElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for (ElevatorService elevator : elevators) {
            if (elevator.getElevator().getDirection().equals(direction) || elevator.getElevator().getDirection().equals(Elevator.Direction.IDLE)) {
                int distance = Math.abs(elevator.getElevator().getCurrentFloor() - currentFloor);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestElevator = elevator;
                }
            }
        }
        if (nearestElevator == null) {
            throw new RuntimeException("No elevator found");
        }
        return nearestElevator;
    }
}
