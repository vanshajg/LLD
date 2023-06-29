package com.vanshajgirotra.tic.tac.toe.models;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Player {

    private final String name;
    private final String selectedCharacter;
}
