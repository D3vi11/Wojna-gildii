package org.example.entities;

public class Archer extends Entity {

    public Archer(int entityNumber) {
        super(entityNumber);
        setAttack(70);
        setHp(800);
        setArmor(60);
        setCrit(30);
        setCritModifier(3);
    }

    @Override
    public void crit(Entity enemy, int critModifier) {
        enemy.takeDamage(getAttack()*critModifier);
        if (enemy.getAttack() >= 10) enemy.setAttack(enemy.getAttack() - 5);
    }
}

