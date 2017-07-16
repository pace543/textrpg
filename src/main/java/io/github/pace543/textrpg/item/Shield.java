package io.github.pace543.textrpg.item;

import io.github.pace543.textrpg.battle.Element;

public enum Shield implements ItemType {
    BRASS       ("Brass Shield", 200, Element.NEUTRAL, 2, 0),
    BRONZE      ("Bronze Shield", 400, Element.NEUTRAL, 4, 2),
    IRON        ("Iron Shield", 600, Element.NEUTRAL, 6, 4),
    SILVER      ("Silver Shield", 800, Element.NEUTRAL, 8, 6),
    GOLD        ("Gold Shield", 1200, Element.NEUTRAL, 10, 8),
    DIAMOND     ("Diamond Shield", 1600, Element.NEUTRAL, 12, 10),
    PLATINUM    ("Platinum Shield", 2400, Element.NEUTRAL, 16, 14),
    FIRE        ("Fire Shield", 1000, Element.FIRE, 9, 7),
    WATER       ("Water Shield", 1000, Element.WATER, 9, 7),
    AIR         ("Air Shield", 1000, Element.AIR, 9, 7),
    EARTH       ("Earth Shield", 1000, Element.EARTH, 9, 7),
    ELECTRIC    ("Electric Shield", 1000, Element.ELECTRIC, 9, 7);

    private String name;
    private int cost;
    private Element element;
    private int pDef;
    private int mDef;

    Shield(String name, int cost, Element element, int pDef, int mDef) {
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
