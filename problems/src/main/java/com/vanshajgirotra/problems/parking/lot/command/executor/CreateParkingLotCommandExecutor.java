package com.vanshajgirotra.problems.parking.lot.command.executor;

import static com.vanshajgirotra.problems.parking.lot.utilities.IntegerValidator.isInteger;

import com.vanshajgirotra.problems.parking.lot.models.Command;
import com.vanshajgirotra.problems.parking.lot.models.parking.strategy.NaturalParkingStrategy;
import com.vanshajgirotra.problems.parking.lot.services.ParkingLotService;

public class CreateParkingLotCommandExecutor extends CommandExecutor {

    public CreateParkingLotCommandExecutor(Command command, ParkingLotService parkingLotService) {
        super(command, parkingLotService);
    }

    @Override
    public void execute() {
        parkingLotService.createParkingLot(Integer.parseInt(command.getArgs().get(0)), new NaturalParkingStrategy());
        System.out.println("Created a parking lot with " + command.getArgs().get(0) + " slots");
    }

    @Override
    public boolean validate() {
        return command.getArgs().size() == 1 && isInteger(command.getArgs().get(0));
    }
}
