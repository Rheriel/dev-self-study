package com.devious.ban.item.throwable;

import com.devious.ban.enemy.Enemy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bomb implements Throwable {
    private Double damage;

    @Override
    public void launch(final Enemy enemy) {
        log.info("Throwing a bomb!");
        enemy.damage();
    }
}
