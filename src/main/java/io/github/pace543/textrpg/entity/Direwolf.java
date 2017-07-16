package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.Attack;

public class Direwolf extends Enemy {
    public Direwolf(int floorNum) {
        super("Direwolf", 20,
                20,
                0,
                0,
                8,
                4,
                0,
                4,
                6,
                floorNum,
                100);

    }

    @Override
    public Attack ai(Player player) {
        return null;
    }
}
