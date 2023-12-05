package com.vanshajgirotra.designpatterns.strategy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.jupiter.api.Test;

import com.vanshajgirotra.designpatterns.strategy.drive.HeavyDriver;
import com.vanshajgirotra.designpatterns.strategy.drive.LightDriver;

public class VehicleTest {
    @Test
    void fortunerDriversAreBad() {
        // given fortuner
        Vehicle fortuner = new Fortuner();

        // when, then
        assertThat(fortuner.getDriverStrategy(), instanceOf(LightDriver.class));
    }

    @Test
    void validateTruckDriversAreHeavy() {
        Vehicle truck = new Truck();

        assertThat(truck.getDriverStrategy(), instanceOf(HeavyDriver.class));
    }
}
