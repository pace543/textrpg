package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.PhysAttack;
import io.github.pace543.textrpg.item.*;

import java.util.ArrayList;

public class Player extends Entity {
    private Item armor = null;
    private Item shield = null;
    private Item weapon = null;
    private int money;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player(String name) {
        super(name, 10, 10,
                20, 20,4, 4, 4, 4, 3);
        this.money = 0;
        this.getPhysAttacks().add(PhysAttack.ATTACK);
    }

    public Player(String name, int health, int maxHealth, int magic, int maxMagic, int pAttack,
                  int pDefense, int mAttack, int mDefense, int speed, int money) {
        super(name, health, maxHealth, magic, maxMagic, pAttack, pDefense, mAttack, mDefense, speed);
        this.money = money;
    }

    public void battle() {

    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Item getArmor() {
        return armor;
    }

    public void setArmor(Item armor) {
        this.armor = armor;
    }

    public Item getShield() {
        return shield;
    }

    public void setShield(Item shield) {
        this.shield = shield;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }
}
