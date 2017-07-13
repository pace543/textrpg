package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.MagAttack;
import io.github.pace543.textrpg.battle.PhysAttack;

import java.util.ArrayList;

public abstract class Entity {
    private String name;
    private int health;
    private int maxHealth;
    private int magic;
    private int maxMagic;
    private int pAttack;
    private int pDefense;
    private int mAttack;
    private int mDefense;
    private int speed;
    private ArrayList<PhysAttack> physAttacks = new ArrayList<>();
    private ArrayList<MagAttack> magAttacks = new ArrayList<>();

    public Entity(String name, int health, int maxHealth, int magic, int maxMagic,
                  int pAttack, int pDefense, int mAttack, int mDefense, int speed) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.magic = magic;
        this.maxMagic = maxMagic;
        this.pAttack = pAttack;
        this.pDefense = pDefense;
        this.mAttack = mAttack;
        this.mDefense = mDefense;
        this.speed = speed;
    }

    public abstract void battle();

    public String getName() {
        return name;
    }

    public ArrayList<PhysAttack> getPhysAttacks() {
        return physAttacks;
    }

    public ArrayList<MagAttack> getMagAttacks() {
        return magAttacks;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMagic() { return magic; }

    public void setMagic(int magic) {
        this.magic = magic;
        if (magic > maxMagic) {
            magic = maxMagic;
        }
    }

    public int getMaxMagic() {
        return maxMagic;
    }

    public int getpAttack() {
        return pAttack;
    }

    public int getpDefense() {
        return pDefense;
    }

    public int getmAttack() {
        return mAttack;
    }

    public int getmDefense() {
        return mDefense;
    }

    public int getSpeed() {
        return speed;
    }
}
