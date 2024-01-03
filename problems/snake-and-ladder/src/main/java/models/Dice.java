package models;

import java.util.concurrent.ThreadLocalRandom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Dice {

    private final int maxValue;
    private final int diceCount;

    public int roll() {
        int sum = 0;
        for (int i = 0; i < diceCount; i++) {
            sum += ThreadLocalRandom.current().nextInt(1, maxValue + 1);
        }
        return sum;
    }
}
