package com.vanshajgirotra.problems.parking.lot.models;

import static java.util.Objects.isNull;

import lombok.Data;

@Data
public class Slot {
    private int slotNumber;
    private Car car;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isEmpty() {
        return isNull(car);
    }

    public boolean isOccupied() {
        return !isEmpty();
    }

    public void park(Car car) {
        if (!isEmpty()) {
            throw new RuntimeException("Slot is not empty");
        }
        this.car = car;
    }

    public void leave() {
        if (isEmpty()) {
            throw new RuntimeException("Slot is already empty");
        }
        this.car = null;
    }

}
