package com.vanshajgirotra.problems.parking.lot.services;

import java.util.List;

import com.vanshajgirotra.problems.parking.lot.models.Car;
import com.vanshajgirotra.problems.parking.lot.models.ParkingLot;
import com.vanshajgirotra.problems.parking.lot.models.Slot;
import com.vanshajgirotra.problems.parking.lot.models.parking.strategy.ParkingStrategy;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public void createParkingLot(int capacity, ParkingStrategy parkingStrategy) {
        if (parkingLot != null) {
            throw new RuntimeException("Parking lot already exists");
        }
        this.parkingLot = new ParkingLot(capacity);
        this.parkingStrategy = parkingStrategy;
        for (int i = 1; i <= capacity; i++) {
            this.parkingStrategy.addSlot(i);
        }
    }

    public Slot park(Car car) {
        validateParkingLotExists();
        int slotNumber = this.parkingStrategy.getNextSlot();
        parkingStrategy.removeSlot(slotNumber);
        return parkingLot.park(car, slotNumber);
    }

    public List<Slot> getParkedSlots() {
        validateParkingLotExists();
        return parkingLot.getSlots()
                .values()
                .stream()
                .filter(Slot::isOccupied)
                .toList();

    }

    public void leave(int slotNumber) {
        validateParkingLotExists();
        parkingLot.leave(slotNumber);
        parkingStrategy.addSlot(slotNumber);
    }

    private void validateParkingLotExists() {
        if (parkingLot == null) {
            throw new RuntimeException("Parking lot does not exist");
        }
    }

}
