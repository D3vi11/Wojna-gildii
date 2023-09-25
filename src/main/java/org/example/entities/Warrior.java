package org.example.entities;

public class Warrior extends Entity {

    public Warrior() {
        super();
        setAttack(65);
        setHp(1000);
        setArmor(70);
        setCrit(35);
        setCritModifier(2);
        warriorCount++;
        setEntityNumber(warriorCount);
    }

    @Override
    public void crit(Entity enemy, int critModifier) {
        enemy.takeDamage(getAttack()*critModifier);
    }

}
