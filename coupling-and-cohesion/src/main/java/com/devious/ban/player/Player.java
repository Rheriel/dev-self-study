package com.devious.ban.player;

import com.devious.ban.enemy.Enemy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Player {

    private String name;

    public void attack(final Enemy enemy) {
        log.info("Attacking enemy!");
        enemy.damage();
    }
}
