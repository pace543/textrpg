package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.MagAttack;
import io.github.pace543.textrpg.battle.PhysAttack;
import io.github.pace543.textrpg.item.*;

import java.util.ArrayList;
import java.util.EnumSet;

public class Player extends Entity {
    private Item armor = null;
    private Item shield = null;
    private Item weapon = null;
    private int money;

    public int getLevel() {
        return level;
    }

    private int level;
    private int exp;
    private static final int BASE_EXP_REQ = 50;
    private ArrayList<Item> inventory = new ArrayList<>();
    private EnumSet<MagAttack> magAttacks;

    public Player(String name) {
        super(name, 10, 10,
                20, 20,4, 4, 4, 4, 3);
        this.money = 0;
        this.level = 1;
        this.exp = BASE_EXP_REQ;
        this.magAttacks = EnumSet.noneOf(MagAttack.class);
    }

    public boolean levelUp() {
        int expReq = (int) (BASE_EXP_REQ * Math.pow(level + 1, 3.0 / 2.0));
        if (exp >= expReq) {
            this.setMaxHealth(10 * (int) Math.sqrt(20 * level));
            this.setMaxMagic(20 * (int) Math.sqrt(20 * level));
            this.setpAttack(4 * (int) Math.sqrt(20 * level));
            this.setpDefense(4 * (int) Math.sqrt(20 * level));
            this.setmAttack(4 * (int) Math.sqrt(20 * level));
            this.setmDefense(4 * (int) Math.sqrt(20 * level));
            this.setSpeed(3 * (int) Math.sqrt(20 * level));
            level++;
            learnAttacks();
            return true;
        } else {
            return false;
        }
    }

    private void learnAttacks() {
        switch (level) {
            case 2:
                this.magAttacks.add(MagAttack.FLAME);
                break;
            case 3:
                this.magAttacks.add(MagAttack.TIDE);
                break;
            case 4:
                this.magAttacks.add(MagAttack.GALE);
                break;
            case 5:
                this.magAttacks.add(MagAttack.SHAKE);
                break;
            case 6:
                this.magAttacks.add(MagAttack.ZAP);
                break;
            case 7:
                this.magAttacks.add(MagAttack.BLAST);
                break;
            case 8:
                this.magAttacks.add(MagAttack.HEAL);
                break;
            case 9:
                this.magAttacks.add(MagAttack.FIREBALL);
                break;
            case 10:
                this.magAttacks.add(MagAttack.FLOOD);
                break;
            case 11:
                this.magAttacks.add(MagAttack.WIND);
                break;
            case 12:
                this.magAttacks.add(MagAttack.RUMBLE);
                break;
            case 13:
                this.magAttacks.add(MagAttack.BOLT);
                break;
            case 14:
                this.magAttacks.add(MagAttack.BOOM);
                break;
            case 15:
                this.magAttacks.add(MagAttack.MOREHEAL);
                break;
            case 16:
                this.magAttacks.add(MagAttack.FIRESTORM);
                break;
            case 17:
                this.magAttacks.add(MagAttack.TSUNAMI);
                break;
            case 18:
                this.magAttacks.add(MagAttack.WINDSTORM);
                break;
            case 19:
                this.magAttacks.add(MagAttack.EARTHQUAKE);
                break;
            case 20:
                this.magAttacks.add(MagAttack.LIGHTNING);
                break;
            case 21:
                this.magAttacks.add(MagAttack.EXPLODE);
                break;
            case 22:
                this.magAttacks.add(MagAttack.MAXHEAL);
                break;
        }
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public EnumSet<MagAttack> getMagAttacks() {
        return magAttacks;
    }
}
