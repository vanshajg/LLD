package models.parking.strategy;

public interface ParkingStrategy {

    void addSlot(int slotNumber);

    void removeSlot(int slotNumber);

    Integer getNextSlot();

}
