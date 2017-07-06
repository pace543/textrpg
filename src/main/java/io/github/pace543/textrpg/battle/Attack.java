package io.github.pace543.textrpg.battle;

import io.github.pace543.textrpg.controller.Command;
import io.github.pace543.textrpg.entity.Entity;

public class Attack implements Command {
    private Entity attacker;
    private Entity defender;
    private AttackType attack;

    public Attack(Entity attacker, Entity defender, AttackType attack) {
        this.attacker = attacker;
        this.defender = defender;
        this.attack = attack;
    }

    public Entity getAttacker() {
        return attacker;
    }

    public Entity getDefender() {
        return defender;
    }

    public AttackType getAttack() {
        return attack;
    }

    @Override
    public void execute() {

    }
}
