package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.Attack;


public class Zombie extends Enemy {
    public Zombie(int floorNum) {
        super("Goblin", 15,
                15,
                15,
                15,
                6,
                6,
                6,
                6,
                10,
                floorNum,
                100);
    }

    @Override
    public Attack ai(Player player) {
        return null;
    }
}
