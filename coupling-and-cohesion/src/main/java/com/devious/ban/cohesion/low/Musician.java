package com.devious.ban.cohesion.low;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Musician {
    private String name;

    public void playGuitar(){
        log.info("Playing the guitar.");
    }

    public void playBass(){
        log.info("Playing the bass.");
    }

    public void playDrums(){
        log.info("Playing the drums.");
    }

    public void playHarmonica(){
        log.info("Playing the harmonica.");
    }
}
