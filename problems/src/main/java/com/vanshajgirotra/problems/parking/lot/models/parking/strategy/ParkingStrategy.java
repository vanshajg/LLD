package com.vanshajgirotra.problems.parking.lot.models.parking.strategy;

public interface ParkingStrategy {

    void addSlot(int slotNumber);

    void removeSlot(int slotNumber);

    Integer getNextSlot();

}
