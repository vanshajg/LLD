package command.executor;

import java.util.List;

import models.Command;
import models.Slot;
import services.ParkingLotService;


public class StatusCommandExecutor extends CommandExecutor {

    public StatusCommandExecutor(Command command, ParkingLotService parkingLotService) {
        super(command, parkingLotService);
    }

    @Override
    public void execute() {
        List<Slot> occupiedSlots = this.parkingLotService.getParkedSlots();
        occupiedSlots.forEach(slot -> System.out.println(slot.getSlotNumber() + " " + slot.getCar().registrationNumber() + " "
                + slot.getCar().color()));
    }

    @Override
    public boolean validate() {
        return this.command.getArgs().isEmpty();
    }
}
