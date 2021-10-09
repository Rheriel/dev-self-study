package com.devious.ban.cohesion.high;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Guitarist {
    private String name;

    public void playGuitar(){
        log.info("Playing the guitar.");
    }
}
