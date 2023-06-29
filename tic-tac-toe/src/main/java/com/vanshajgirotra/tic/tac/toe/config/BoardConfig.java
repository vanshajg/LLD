package com.vanshajgirotra.tic.tac.toe.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "board")
@Data
public class BoardConfig {

    int sideLength;
}
