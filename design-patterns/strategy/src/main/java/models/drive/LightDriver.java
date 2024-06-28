package models.drive;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LightDriver implements DriverStrategy {
    @Override
    public void drive() {
      log.info("light driver!");
    }
}
