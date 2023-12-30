import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import command.executor.CommandExecutor;
import command.executor.CommandExecutorFactory;
import models.Command;
import services.ParkingLotService;


public class ParkingLotApplication {
    public static void main(String[] args) throws IOException {
        final ParkingLotService parkingLotService = new ParkingLotService();

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            final String input = reader.readLine();

            if (input.equals("exit")) {
                break;
            }

            final Command command = new Command(input);
            final CommandExecutor commandExecutor = CommandExecutorFactory.getCommandExecutor(command, parkingLotService);
            if (commandExecutor.validate()) {
                commandExecutor.execute();
            } else {
                System.out.println("Invalid command");
            }

        }

    }
}
