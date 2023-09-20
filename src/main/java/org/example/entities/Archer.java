package org.example.entities;

public class Archer extends Entity {

    public Archer(int entityNumber) {
        super(entityNumber);
        setAttack(70);
        setHp(800);
        setArmor(60);
        setCrit(30);
        setCritModifier(3);
        setAlive(true);
    }

    @Override
    public void attack(EntityInterface enemy) {
        if (!checkInstance(enemy)) {
            if (getCriticalStrikeChance()) {
                crit(enemy, getCritModifier());
            } else
                enemy.setHp((enemy.getHp() - getAttack()) + enemy.getArmor() / 10);
            enemy.death(enemy.getHp());
        }

    }

    @Override
    public void crit(EntityInterface enemy, int critModifier) {
        enemy.setHp((enemy.getHp() - critModifier * getAttack()) + enemy.getArmor() / 10);
        if (enemy.getAttack() >= 10) enemy.setAttack(enemy.getAttack() - 5);
    }
}

