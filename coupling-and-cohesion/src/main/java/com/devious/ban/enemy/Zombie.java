package com.devious.ban.enemy;

import com.devious.ban.behavior.Spawnable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Zombie implements Enemy, Spawnable {

    private Double health;

    @Override
    public void damage() {
        log.info("Zombie getting damage!");
    }

    @Override
    public void spawn() {
        log.info("Zombie spawning!");
    }

    @Override
    public void destroy() {
        log.info("Destroying zombie!");
    }
}
