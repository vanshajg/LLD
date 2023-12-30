package command.executor;


import models.Command;
import services.ParkingLotService;

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
