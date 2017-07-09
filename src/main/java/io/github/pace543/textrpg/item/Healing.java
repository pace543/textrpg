package io.github.pace543.textrpg.item;

import io.github.pace543.textrpg.battle.Element;

public enum Healing implements ItemType {
    POTION          ("Potion", 100, 20, 0),
    SUPER_POTION    ("Super Potion", 250, 50, 0),
    ELIXIR          ("Elixir", 150, 0, 10),
    AURA            ("Aura", 350, 0, 25),
    RESTORER        ("Restorer", 500, 100, 50);

    private String name;
    private int cost;
    private int healthBack;
    private int magicBack;
    private Element element = Element.HEAL;

    Healing(String name, int cost, int healthBack, int magicBack) {
        this.name = name;
        this.cost = cost;
        this.healthBack = healthBack;
        this.magicBack = magicBack;
    }

    @Override
    public int getCost() {
        return cost;
    }

    public int getHealthBack() {
        return healthBack;
    }

    public int getMagicBack() {
        return magicBack;
    }

    @Override
    public Element getElement() {
        return element;
    }

    @Override
    public String getName() {
        return name;
    }
}
