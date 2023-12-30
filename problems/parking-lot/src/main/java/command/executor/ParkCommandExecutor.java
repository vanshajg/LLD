package command.executor;


import models.Car;
import models.Command;
import models.Slot;
import services.ParkingLotService;

public class ParkCommandExecutor extends CommandExecutor {

    public ParkCommandExecutor(Command command, ParkingLotService parkingLotService) {
        super(command, parkingLotService);
    }

    @Override
    public void execute() {
        String registrationNumber = this.command.getArgs().get(0);
        String color = this.command.getArgs().get(1);
        Slot slot = this.parkingLotService.park(new Car(registrationNumber, color));
        System.out.println("Allocated slot number: " + slot.getSlotNumber());
    }

    @Override
    public boolean validate() {
        return this.command.getArgs().size() == 2;
    }
}
