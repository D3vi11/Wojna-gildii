package org.example.entities;

public class Warrior extends Entity {

    public Warrior(int entityNumber) {
        super(entityNumber);
        setAttack(65);
        setHp(1000);
        setArmor(70);
        setCrit(35);
        setCritModifier(2);
        setAlive(true);
    }

    @Override
    public void attack(EntityInterface enemy) {
        if (!checkInstance(enemy)) {
            if (getCriticalStrikeChance())
                crit(enemy, getCritModifier());
            else
                enemy.setHp((enemy.getHp() - getAttack()) + enemy.getArmor() / 10);
            enemy.death(enemy.getHp());
        }
    }

    @Override
    public void crit(EntityInterface enemy, int critModifier) {
        enemy.setHp((enemy.getHp() - critModifier * getAttack()) + enemy.getArmor() / 10);
    }

}
