package org.example.entities;

public class Mage extends Entity {
    private int mana;
    private final int manaDmg;

    public Mage(int entityNumber) {
        super(entityNumber);
        setAttack(80);
        setHp(700);
        setArmor(40);
        mana = 200;
        manaDmg = 30;
        setCrit(25);
        setCritModifier(2);
        setAlive(true);
    }

    @Override
    public void attack(Entity enemy) {
        if (checkInstance(enemy)) {
            if (rollCrit()) {
                crit(enemy, getCritModifier());
            } else {
                if (mana == 0) {
                    enemy.setHp((enemy.getHp() - getAttack()) + enemy.getArmor() / 10);
                } else {
                    enemy.setHp(enemy.getHp() - (getAttack() + manaDmg) + getArmor() / 10);
                    mana -= 10;
                }

            }
            enemy.death(enemy.getHp());
        }
    }

    @Override
    public void crit(Entity enemy, int critModifier) {
        if (mana == 0) {
            enemy.setHp((enemy.getHp() - critModifier * getAttack() + enemy.getArmor() / 10));
        } else {
            enemy.setHp(enemy.getHp() - (critModifier * getAttack() + manaDmg) + getArmor() / 10);
            mana -= 10;
        }
    }

}
