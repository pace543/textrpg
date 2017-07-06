package io.github.pace543.textrpg.battle;

public enum MagAttack implements AttackType {
    FLAME       ("Flame", 3, Element.FIRE, 5, 0.95, 0.25),
    FIREBALL    ("Fireball", 8, Element.FIRE, 14, 0.85, 0.15),
    FIRESTORM   ("Firestorm", 15, Element.FIRE, 25, 0.75, 0.05),
    TIDE        ("Tide", 3, Element.WATER, 5, 0.95, 0.25),
    FLOOD       ("Flood", 8, Element.WATER, 14, 0.85, 0.15),
    TSUNAMI     ("Tsunami", 15, Element.WATER, 25, 0.75, 0.05),
    GALE        ("Gale", 3, Element.AIR, 5, 0.95, 0.25),
    WIND        ("Wind", 8, Element.AIR, 14, 0.85, 0.15),
    WINDSTORM   ("Windstorm", 15, Element.AIR, 25, 0.75, 0.05),
    SHAKE       ("Shake", 3, Element.EARTH, 5, 0.95, 0.25),
    RUMBLE      ("Rumble", 8, Element.EARTH, 14, 0.85, 0.15),
    EARTHQUAKE  ("Earthquake", 15, Element.EARTH, 25, 0.75, 0.05),
    ZAP         ("Zap", 3, Element.ELECTRIC, 5, 0.95, 0.25),
    BOLT        ("Bolt", 8, Element.ELECTRIC, 14, 0.85, 0.15),
    LIGHTNING   ("Lightning", 15, Element.ELECTRIC, 25, 0.75, 0.05),
    BLAST       ("Blast", 3, Element.NEUTRAL, 5, 0.95, 0.25),
    BOOM        ("Boom", 8, Element.NEUTRAL, 14, 0.85, 0.15),
    EXPLODE     ("Explode", 15, Element.NEUTRAL, 25, 0.75, 0.05),
    HEAL        ("Heal", 3, Element.HEAL, 5, 0.95, 0.25),
    MOREHEAL    ("Moreheal", 8, Element.HEAL, 14, 0.85, 0.15),
    MAXHEAL     ("Maxheal", 15, Element.HEAL, 25, 0.75, 0.05);

    private String name;
    private int cost;
    private Element element;
    private int power;
    private double accuracy;
    private double critical;

    MagAttack(String name, int cost, Element element, int power, double accuracy, double critical) {
        this.name = name;
        this.cost = cost;
        this.element = element;
        this.power = power;
        this.accuracy = accuracy;
        this.critical = critical;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public double getAccuracy() {
        return this.accuracy;
    }

    @Override
    public double getCritical() {
        return this.critical;
    }

    public int getCost() {
        return this.cost;
    }

    public Element getElement() { return this.element; }
}
