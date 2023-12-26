package com.vanshajgirotra.problems.parking.lot.command.executor;

import com.vanshajgirotra.problems.parking.lot.models.Command;
import com.vanshajgirotra.problems.parking.lot.services.ParkingLotService;

public abstract class CommandExecutor {
    protected Command command;
    protected ParkingLotService parkingLotService;

    public CommandExecutor(Command command, ParkingLotService parkingLotService) {
        this.command = command;
        this.parkingLotService = parkingLotService;
    }

    public abstract void execute();

    public abstract boolean validate();

}
