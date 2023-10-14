package com.vanshajgirotra.problems.tictactoe.models;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Player {

    private final String name;
    private final String selectedCharacter;
}
