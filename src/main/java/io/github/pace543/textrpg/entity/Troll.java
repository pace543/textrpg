package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.Attack;

public class Troll extends Enemy {
    public Troll(int floorNum) {
        super("Troll", 40,
                40,
                10,
                10,
                12,
                8,
                2,
                8,
                2,
                floorNum,
                120);
    }

    @Override
    public Attack ai(Player player) {
        return null;
    }
}
