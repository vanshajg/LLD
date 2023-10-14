package com.vanshajgirotra.problems.tictactoe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "tic-tac-toe.game")
public class GameConfig {

    private int maxPlayers;
}
