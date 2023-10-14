package com.vanshajgirotra.problems.tictactoe.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "tic-tac-toe.board")
@Data
public class BoardConfig {

    int sideLength;
}
