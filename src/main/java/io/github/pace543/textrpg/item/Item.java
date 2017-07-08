package io.github.pace543.textrpg.item;

public class Item {
    private ItemType thing;
    private double health;

    public Item(ItemType thing, double health) {
        this.thing = thing;
        this.health = health;
    }

    public Item(ItemType thing) {
        this(thing, 1.00);
    }

    public ItemType getThing() {
        return thing;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
