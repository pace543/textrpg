package io.github.pace543.textrpg.entity;

import io.github.pace543.textrpg.battle.Attack;
import io.github.pace543.textrpg.battle.Element;
import io.github.pace543.textrpg.controller.RNG;

public abstract class Enemy extends Entity {
    private int expAwarded;
    private Element element;

    Enemy(String name, int health, int maxHealth, int magic,
          int maxMagic, int pAttack, int pDefense, int mAttack,
          int mDefense, int speed, int floorNum, int baseExpAwarded) {
        super(name, health * (int) Math.sqrt(floorNum),
                maxHealth * (int) Math.sqrt(floorNum),
                magic * (int) Math.sqrt(floorNum),
                maxMagic * (int) Math.sqrt(floorNum),
                pAttack * (int) Math.sqrt(floorNum),
                pDefense * (int) Math.sqrt(floorNum),
                mAttack * (int) Math.sqrt(floorNum),
                mDefense * (int) Math.sqrt(floorNum),
                speed * (int) Math.sqrt(floorNum));
        this.expAwarded = baseExpAwarded * ((int) Math.log(Math.pow(floorNum, 3)) + 1);

        if (floorNum < 10) {
            this.element = Element.NEUTRAL;
        } else if (this instanceof Zombie) {
            this.element = Element.HEAL;
        } else {
            int rand = RNG.getRInt(7);
            switch (rand) {
                case 0:case 1:
                    this.element = Element.NEUTRAL;
                    break;
                case 2:
                    this.element = Element.FIRE;
                    break;
                case 3:
                    this.element = Element.ELECTRIC;
                    break;
                case 4:
                    this.element = Element.WATER;
                    break;
                case 5:
                    this.element = Element.EARTH;
                    break;
                case 6:
                    this.element = Element.AIR;
                    break;
            }
        }
    }

    public abstract Attack ai(Player player);

    public int getExpAwarded() {
        return expAwarded;
    }

    public Element getElement() {
        return element;
    }
}
