package com.vanshajgirotra.problems.parking.lot.models.parking.strategy;

import java.util.TreeSet;

public class NaturalParkingStrategy implements ParkingStrategy {
    TreeSet<Integer> slots;

    public NaturalParkingStrategy() {
        this.slots = new TreeSet<>();
    }

    @Override
    public void addSlot(int slotNumber) {
        this.slots.add(slotNumber);
    }

    @Override
    public void removeSlot(int slotNumber) {
        this.slots.remove(slotNumber);
    }

    @Override
    public Integer getNextSlot() {
        if (this.slots.isEmpty()) {
            throw new RuntimeException("No slots available");
        }
        return this.slots.first();
    }
}
