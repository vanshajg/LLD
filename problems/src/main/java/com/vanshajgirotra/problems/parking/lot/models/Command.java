package com.vanshajgirotra.problems.parking.lot.models;

import java.util.List;

import lombok.Getter;

@Getter
public class Command {
    private final String command;
    private final List<String> args;

    public Command(String input) {
        List<String> commands = List.of(input.split(" "));
        this.command = commands.get(0);
        this.args = commands.subList(1, commands.size());
    }

}
