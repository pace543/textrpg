package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.MagAttack;
import io.github.pace543.textrpg.battle.PhysAttack;

import java.util.ArrayList;

public abstract class Entity {
    private String name;
    private double health;
    private double maxHealth;
    private double magic;
    private double maxMagic;
    private double pAttack;
    private double pDefense;
    private double mAttack;
    private double mDefense;
    private double speed;
    private ArrayList<PhysAttack> physAttacks = new ArrayList<>();
    private ArrayList<MagAttack> magAttacks = new ArrayList<>();

    public Entity(String name, double health, double maxHealth, double magic, double maxMagic,
                  double pAttack, double pDefense, double mAttack, double mDefense, double speed) {
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

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getMagic() {
        return magic;
    }

    public double getMaxMagic() {
        return maxMagic;
    }

    public double getpAttack() {
        return pAttack;
    }

    public double getpDefense() {
        return pDefense;
    }

    public double getmAttack() {
        return mAttack;
    }

    public double getmDefense() {
        return mDefense;
    }

    public double getSpeed() {
        return speed;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setMagic(double magic) {
        this.magic = magic;
    }

    public void setMaxMagic(double maxMagic) {
        this.maxMagic = maxMagic;
    }

    public void setpAttack(double pAttack) {
        this.pAttack = pAttack;
    }

    public void setpDefense(double pDefense) {
        this.pDefense = pDefense;
    }

    public void setmAttack(double mAttack) {
        this.mAttack = mAttack;
    }

    public void setmDefense(double mDefense) {
        this.mDefense = mDefense;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public ArrayList<PhysAttack> getPhysAttacks() {
        return physAttacks;
    }

    public ArrayList<MagAttack> getMagAttacks() {
        return magAttacks;
    }
}
