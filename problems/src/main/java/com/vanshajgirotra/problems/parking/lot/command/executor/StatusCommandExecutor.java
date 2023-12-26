package com.vanshajgirotra.problems.parking.lot.command.executor;

import java.util.List;

import com.vanshajgirotra.problems.parking.lot.models.Command;
import com.vanshajgirotra.problems.parking.lot.models.Slot;
import com.vanshajgirotra.problems.parking.lot.services.ParkingLotService;

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
