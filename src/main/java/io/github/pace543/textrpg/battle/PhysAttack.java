package io.github.pace543.textrpg.battle;

public enum PhysAttack implements AttackType {
    ATTACK          ("Attack", 30, 0.95, 0.20),
    SUPER_ATTACK    ("Super Attack", 50, 0.90, 0.10),
    RAGE_ATTACK     ("Rage Attack", 100, 0.75, 0.04),
    CHOP            ("Chop", 20, 0.95, 0.25),
    DUAL_CHOP       ("Dual Chop", 40, 0.90, 0.15),
    KICK            ("Kick", 25, 0.93, 0.20),
    TACKLE          ("Tackle", 40, 0.95, 0.10),
    BITE            ("Bite", 35, 0.88, 0.20);

    private String name;
    private int power;
    private double accuracy;
    private double critical;

    PhysAttack(String name, int power, double accuracy, double critical) {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
        this.critical = critical;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public double getAccuracy() {
        return accuracy;
    }

    @Override
    public double getCritical() {
        return critical;
    }
}
