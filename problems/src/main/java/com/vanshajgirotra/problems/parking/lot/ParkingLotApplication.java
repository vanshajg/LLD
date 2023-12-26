package com.vanshajgirotra.problems.parking.lot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.vanshajgirotra.problems.parking.lot.command.executor.CommandExecutor;
import com.vanshajgirotra.problems.parking.lot.command.executor.CommandExecutorFactory;
import com.vanshajgirotra.problems.parking.lot.models.Command;
import com.vanshajgirotra.problems.parking.lot.services.ParkingLotService;

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
