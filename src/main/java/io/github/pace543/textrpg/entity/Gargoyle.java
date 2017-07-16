package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.Attack;

public class Gargoyle extends Enemy {
    public Gargoyle(int floorNum) {
        super("Gargoyle", 30,
                30,
                0,
                0,
                3,
                20,
                0,
                20,
                2,
                floorNum,
                90);
    }

    @Override
    public Attack ai(Player player) {
        return null;
    }
}