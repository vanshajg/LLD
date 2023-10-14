package com.vanshajgirotra.designpatterns.strategy;

import com.vanshajgirotra.designpatterns.strategy.drive.DriverStrategy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Vehicle {
    private final DriverStrategy driveStrategy;
    public void drive() {
        driveStrategy.drive();
    }
}
