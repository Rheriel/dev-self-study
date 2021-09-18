package com.devious.ban.enemy;

import com.devious.ban.behavior.Spawnable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Vampire implements Enemy, Spawnable {
    private Double health;

    @Override
    public void damage() {
        log.info("Vampire getting damage!");
    }

    @Override
    public void spawn() {
        log.info("Vampire spawning!");
    }

    @Override
    public void destroy() {
        log.info("Destroying vampire!");
    }
}
