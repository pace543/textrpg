package io.github.pace543.textrpg.item;

import io.github.pace543.textrpg.battle.Element;

public enum Weapon implements ItemType {
    SIMPLESWORD ("Simple Sword", 400, Element.NEUTRAL, 10),
    SCIMITAR    ("Scimitar", 800, Element.NEUTRAL, 15),
    LONGSWORD   ("Longsword", 1200, Element.NEUTRAL, 20),
    KATANA      ("Katana", 1600, Element.NEUTRAL, 25),
    ZWEIHANDER  ("Zweihander", 2400, Element.NEUTRAL, 30),
    CLAYMORE    ("Claymore", 3200, Element.NEUTRAL, 35),
    RAPIER      ("Rapier", 4000, Element.NEUTRAL, 40),
    FIRE        ("Fire Sword", 1800, Element.FIRE, 28),
    WATER       ("Water Sword", 1800, Element.WATER, 28),
    AIR         ("Air Sword", 1800, Element.AIR, 28),
    EARTH       ("Earth Sword", 1800, Element.EARTH, 28),
    ELECTRIC    ("Electric Sword", 1800, Element.ELECTRIC, 28);

    private String name;
    private int cost;
    private Element element;
    private int pDamage;

    Weapon(String name, int cost, Element element, int pDamage) {
        this.name = name;
        this.cost = cost;
        this.element = element;
        this.pDamage = pDamage;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public Element getElement() {
        return element;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getpDamage() {
        return pDamage;
    }

    @Override
    public String toString() {
        return this.getName() + " <" + this.getElement().name() + "> ATK: " + this.getpDamage()
                + " COST: " + this.getCost();
    }
}
