package models.drive;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeavyDriver implements DriverStrategy {
    @Override
    public void drive() {
        log.info("heavy driver1!!1");
    }
}
