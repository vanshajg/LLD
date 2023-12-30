package models;

import lombok.Data;

@Data
public class Elevator {

    private int id;
    private int currentFloor;
    private Direction direction;
    private Status status;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.status = Status.IDLE;
    }

    public enum Direction {
        UP, DOWN, IDLE
    }

    public enum Status {
        MOVING, IDLE
    }

}
