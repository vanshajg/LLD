package models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import models.drive.DriverStrategy;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Vehicle {

    private final DriverStrategy driverStrategy;
    public void drive() {
        driverStrategy.drive();
    }

}
