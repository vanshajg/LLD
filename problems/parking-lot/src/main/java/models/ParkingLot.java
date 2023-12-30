package models;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ParkingLot {
    private static final int MAX_CAPACITY = 100;
    private int numberOfSlots;
    private Map<Integer, Slot> slots;

    public ParkingLot(final int numberOfSlots) {

        if (numberOfSlots > MAX_CAPACITY || numberOfSlots < 1) {
            throw new RuntimeException("Invalid number of slots: " + numberOfSlots);
        }
        this.numberOfSlots = numberOfSlots;
        this.slots = new HashMap<>();
    }


    private Slot getSlot(final Integer slotNumber) {
        if (slotNumber > numberOfSlots || slotNumber < 1) {
            throw new RuntimeException("Invalid slot number: " + slotNumber);
        }
        if (!slots.containsKey(slotNumber)) {
            slots.put(slotNumber, new Slot(slotNumber));
        }
        return slots.get(slotNumber);
    }

    public Slot park(final Car car, final Integer slotNumber) {
        final Slot slot = getSlot(slotNumber);
        if (!slot.isEmpty()) {
            throw new RuntimeException("Slot " + slotNumber + " is already occupied");
        }
        slot.park(car);
        return slot;
    }

    public void leave(Integer slotNumber) {
        getSlot(slotNumber).leave();
    }
    
}
