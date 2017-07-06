package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.PhysAttack;
import io.github.pace543.textrpg.item.Armor;
import io.github.pace543.textrpg.item.Inventory;
import io.github.pace543.textrpg.item.Shield;
import io.github.pace543.textrpg.item.Weapon;

public class Player extends Entity {
    private static Player player = null;

    private Armor armor = null;
    private Shield shield = null;
    private Weapon weapon = null;
    private Inventory inventory = null;

    private Player(String name) {
        super(name, 10, 10,
                20, 20,4, 4, 4, 4, 3);
        this.getPhysAttacks().add(PhysAttack.ATTACK);
    }

    private Player(String name, int health, int maxHealth, int magic, int maxMagic, int pAttack,
                  int pDefense, int mAttack, int mDefense, int speed) {
        super(name, health, maxHealth, magic, maxMagic, pAttack, pDefense, mAttack, mDefense, speed);
    }

    public static Player getInstance(String name) {
        player = new Player(name);
        return player;
    }

    public static Player getInstance(String name, int health, int maxHealth, int magic, int maxMagic, int pAttack,
                                     int pDefense, int mAttack, int mDefense, int speed) {
        player = new Player(name, health, maxHealth, magic, maxMagic, pAttack, pDefense, mAttack, mDefense, speed);
        return player;
    }

    public void battle() {

    }
}