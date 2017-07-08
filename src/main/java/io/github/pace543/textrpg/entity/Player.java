package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.PhysAttack;
import io.github.pace543.textrpg.item.*;

import java.util.ArrayList;

public class Player extends Entity {
    private static Player player = null;

    private Armor armor = null;
    private Shield shield = null;
    private Weapon weapon = null;
    private ArrayList<Item> inventory = new ArrayList<>();

    private Player(String name) {
        super(name, 10, 10,
                20, 20,4, 4, 4, 4, 3);
        this.getPhysAttacks().add(PhysAttack.ATTACK);
    }

    private Player(String name, int health, int maxHealth, int magic, int maxMagic, int pAttack,
                  int pDefense, int mAttack, int mDefense, int speed) {
        super(name, health, maxHealth, magic, maxMagic, pAttack, pDefense, mAttack, mDefense, speed);
    }

    public void battle() {

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

    public Shield getShield() {
        return shield;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void equipArmor(Armor armor) {
        this.armor = armor;
    }

    public void unequipArmor() {
        this.armor = null;
    }

    public void equipShield(Shield shield) {
        this.shield = shield;
    }

    public void unequipShield() {
        this.shield = null;
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void unequipWeapon() {
        this.weapon = null;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
