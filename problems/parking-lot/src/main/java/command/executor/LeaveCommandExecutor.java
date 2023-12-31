package command.executor;


import models.Command;
import services.ParkingLotService;

public class LeaveCommandExecutor extends CommandExecutor {

    public LeaveCommandExecutor(Command command, ParkingLotService parkingLotService) {
        super(command, parkingLotService);
    }

    @Override
    public void execute() {
        int slotNumber = Integer.parseInt(this.command.getArgs().get(0));
        this.parkingLotService.leave(slotNumber);
        System.out.println("Slot number " + slotNumber + " is free");
    }

    @Override
    public boolean validate() {
        return this.command.getArgs().size() == 1;
    }
}
