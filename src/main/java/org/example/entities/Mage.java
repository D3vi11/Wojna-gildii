package org.example.entities;

import lombok.Getter;

@Getter
public class Mage extends Entity {

    private int mana;
    private final int manaDmg;

    public Mage() {
        super(700);
        setAttack(80);
        setHp(getMaxHp());
        setArmor(40);
        mana = 200;
        manaDmg = 30;
        setCrit(25);
        setCritModifier(2);
        mageCount++;
        setEntityNumber(mageCount);
    }

    @Override
    public void attack(Entity enemy) {
        if (!checkIfInstanceIsSame(enemy)) {
            if (rollCrit()) {
                crit(enemy, getCritModifier());
            } else {
                if (mana == 0) {
                    enemy.takeDamage(getAttack());
                } else {
                    enemy.takeDamage(getAttack() + manaDmg);
                    mana -= 10;
                }
            }
        }
    }

    @Override
    public void crit(Entity enemy, int critModifier) {
        if (mana == 0) {
            enemy.takeDamage(getAttack() * critModifier);
        } else {
            enemy.takeDamage(getAttack() * critModifier + manaDmg);
            mana -= 10;
        }
    }

}
