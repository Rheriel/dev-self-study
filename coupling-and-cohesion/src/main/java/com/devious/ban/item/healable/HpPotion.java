package com.devious.ban.item.healable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HpPotion implements Healable {
    private Double points;

    @Override
    public void heal() {
        log.info("Healing HP!");
    }
}
