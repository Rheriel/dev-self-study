package com.devious.ban.enemy;

import com.devious.ban.behavior.Spawnable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Orc implements Enemy, Spawnable {
    private Double health;

    @Override
    public void damage() {
        log.info("Orc getting damage!");
    }

    @Override
    public void spawn() {
        log.info("Orc spawning!");
    }

    @Override
    public void destroy() {
        log.info("Destroying orc!");
    }
}
