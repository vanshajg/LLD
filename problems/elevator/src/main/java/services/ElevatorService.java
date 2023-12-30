package services;

import java.util.TreeSet;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import models.Config;
import models.Elevator;

@Slf4j
@Getter
public class ElevatorService {
    private final Elevator elevator;
    private final TreeSet<Integer> floors = new TreeSet<>();


    public ElevatorService(int id) {
        this.elevator = new Elevator(id);
    }

    public void goToFloor(int floor) {
        if (floor < Config.MIN_FLOORS || floor > Config.MAX_FLOORS) {
            throw new RuntimeException("Invalid floor number: " + floor);
        }
        floors.add(floor);
        move();
    }

    public void pressFloorButton(int floor) {
        if (floor < Config.MIN_FLOORS || floor > Config.MAX_FLOORS) {
            throw new RuntimeException("Invalid floor number: " + floor);
        }
        goToFloor(floor);
    }

    private void move() {
        if (floors.isEmpty()) {
            return;
        }
        int currentFloor = elevator.getCurrentFloor();
        Integer nextFloor;
        if (elevator.getDirection().equals(Elevator.Direction.UP)) {
            nextFloor = floors.ceiling(currentFloor);
            if (nextFloor == null) {
                elevator.setDirection(Elevator.Direction.DOWN);
                nextFloor = floors.floor(currentFloor);
            }
        } else {
            nextFloor = floors.floor(currentFloor);
            if (nextFloor == null) {
                elevator.setDirection(Elevator.Direction.UP);
                nextFloor = floors.ceiling(currentFloor);
            }
        }
        log.info("Moving elevator: {} from {} to {}", elevator.getId(), currentFloor, nextFloor);
        if (nextFloor == null) {
            throw new RuntimeException("No next floor found");
        }
        elevator.setCurrentFloor(nextFloor);

    }

}
