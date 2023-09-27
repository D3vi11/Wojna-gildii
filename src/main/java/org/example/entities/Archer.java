package org.example.entities;

public class Archer extends Entity {


    public Archer() {
        super();
        setAttack(70);
        setHp(800);
        setArmor(60);
        setCrit(30);
        setCritModifier(3);
        archerCount++;
        setEntityNumber(archerCount);
    }

    @Override
    public void crit(Entity enemy, int critModifier) {
        enemy.takeDamage(getAttack()*critModifier);
        if (enemy.getAttack() >= 10) enemy.setAttack(enemy.getAttack() - 5);
    }
}

