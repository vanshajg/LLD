package command.executor;

import models.Command;
import services.ParkingLotService;

public class CommandExecutorFactory {

    public static CommandExecutor getCommandExecutor(Command command, ParkingLotService parkingLotService) {
        return switch (command.getCommand()) {
            case "create_parking_lot" -> new CreateParkingLotCommandExecutor(command, parkingLotService);
            case "park" -> new ParkCommandExecutor(command, parkingLotService);
            case "leave" -> new LeaveCommandExecutor(command, parkingLotService);
            case "status" -> new StatusCommandExecutor(command, parkingLotService);
            default -> throw new IllegalArgumentException("Invalid command name: " + command.getCommand());
        };
    }

}
