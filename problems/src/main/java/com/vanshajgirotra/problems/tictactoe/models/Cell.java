package com.vanshajgirotra.problems.tictactoe.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cell {

    public static final String EMPTY_CELL = "_";

    private String cellValue = EMPTY_CELL;
}
