package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.Attack;

public class Necromancer extends Enemy {
    public Necromancer(int floorNum) {
        super("Necromancer", 15,
                15,
                50,
                50,
                1,
                2,
                10,
                10,
                5,
                floorNum,
                120);

    }

    @Override
    public Attack ai(Player player) {
        return null;
    }
}
