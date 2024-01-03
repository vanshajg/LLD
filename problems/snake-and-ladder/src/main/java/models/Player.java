package models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class Player {
    private final String name;
    private int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }
}