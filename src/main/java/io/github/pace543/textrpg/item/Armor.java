package io.github.pace543.textrpg.item;

import io.github.pace543.textrpg.battle.Element;

public enum Armor implements ItemType {
    BRASS       ("Brass Armor", 500, Element.NEUTRAL, 5, 0),
    BRONZE      ("Bronze Armor", 1000, Element.NEUTRAL, 8, 5),
    IRON        ("Iron Armor", 1500, Element.NEUTRAL, 12, 7),
    SILVER      ("Silver Armor", 2000, Element.NEUTRAL, 16, 9),
    GOLD        ("Gold Armor", 3000, Element.NEUTRAL, 20, 12),
    DIAMOND     ("Diamond Armor", 4000, Element.NEUTRAL, 25, 15),
    PLATINUM    ("Platinum Armor", 6000, Element.NEUTRAL, 30, 18),
    FIRE        ("Fire Armor", 2500, Element.FIRE, 18, 10),
    WATER       ("Water Armor", 2500, Element.WATER, 18, 10),
    AIR         ("Air Armor", 2500, Element.AIR, 18, 10),
    EARTH       ("Earth Armor", 2500, Element.EARTH, 18, 10),
    ELECTRIC    ("Electric Armor", 2500, Element.ELECTRIC, 18, 10);

    private String name;
    private int cost;
    private Element element;
    private int pDef;
    private int mDef;

    Armor(String name, int cost, Element element, int pDef, int mDef) {
        this.name = name;
        this.cost = cost;
        this.element = element;
        this.pDef = pDef;
        this.mDef = mDef;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public Element getElement() {
        return element;
    }

    public int getpDef() {
        return pDef;
    }

    public int getmDef() {
        return mDef;
    }

    @Override
    public String toString() {
        return this.getName() + " <" + this.getElement().name() + "> PDEF: " + this.getpDef()
                + " MDEF: " + this.getmDef() + " COST: " + this.getCost();
    }
}
