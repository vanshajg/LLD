package com.vanshajgirotra.problems.parking.lot.command.executor;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vanshajgirotra.problems.parking.lot.models.Command;
import com.vanshajgirotra.problems.parking.lot.services.ParkingLotService;

@ExtendWith(MockitoExtension.class)
class CreateParkingLotCommandExecutorTest {

    @Mock
    private ParkingLotService parkingLotService;


    @Test
    void testValidation() {
        Command command = new Command("create_parking_lot 6");
        CommandExecutor createParkingLotCommandExecutor = new CreateParkingLotCommandExecutor(command, parkingLotService);
        assertThat(createParkingLotCommandExecutor.validate()).isTrue();
    }

    @Test
    void testValidationWithInvalidCommand() {
        Command command = new Command("create_parking_lot");
        CommandExecutor createParkingLotCommandExecutor = new CreateParkingLotCommandExecutor(command, parkingLotService);
        assertThat(createParkingLotCommandExecutor.validate()).isFalse();
    }

    @Test
    void testParkingLotCreation() {
        new CreateParkingLotCommandExecutor(new Command("create_parking_lot 6"), parkingLotService)
                .execute();
        final ArgumentCaptor<Integer> argument = ArgumentCaptor.forClass(Integer.class);
        verify(parkingLotService).createParkingLot(argument.capture(), any());
    }

}