package com.devious.ban.cohesion.high;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bassist {
    private String name;

    public void playBass(){
        log.info("Playing the bass.");
    }
}
