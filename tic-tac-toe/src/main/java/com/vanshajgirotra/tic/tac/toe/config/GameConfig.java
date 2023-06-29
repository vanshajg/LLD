package com.vanshajgirotra.tic.tac.toe.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "game")
public class GameConfig {

    private int maxPlayers;
}
