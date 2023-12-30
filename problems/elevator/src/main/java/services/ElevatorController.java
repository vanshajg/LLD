package services;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import models.Elevator;
import strategy.ElevatorStrategy;

@Slf4j
@RequiredArgsConstructor
public class ElevatorController {

    private final List<ElevatorService> elevators;
    private final ElevatorStrategy elevatorStrategy;

    public void floorButton(int floor, Elevator.Direction direction) {
        ElevatorService elevator = elevatorStrategy.getNextElevator(elevators, floor, direction);
        System.out.println("Elevator " + elevator.getElevator().getId() + " is going to floor " + floor);
        elevator.goToFloor(floor);
    }

}
