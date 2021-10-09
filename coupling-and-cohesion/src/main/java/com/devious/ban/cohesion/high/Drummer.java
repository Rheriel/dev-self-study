package com.devious.ban.cohesion.high;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Drummer {
    private String name;

    public void playDrums(){
        log.info("Playing the drums.");
    }
}
