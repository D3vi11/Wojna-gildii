package org.example.entities;

public class Warrior extends Entity {

    public Warrior() {
        super(1000);
        setAttack(65);
        setHp(getMaxHp());
        setArmor(70);
        setCrit(35);
        setCritModifier(2);
        warriorCount++;
        setEntityNumber(warriorCount);
    }

    @Override
    public void crit(Entity enemy, int critModifier) {
        enemy.takeDamage(getAttack() * critModifier);
    }

}
