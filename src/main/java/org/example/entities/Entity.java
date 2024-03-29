package org.example.entities;

import lombok.*;

import java.util.Random;

@Data
public abstract class Entity {

    @Getter
    @Setter
    protected static int warriorCount = 0;
    @Getter
    @Setter
    protected static int mageCount = 0;
    @Getter
    @Setter
    protected static int archerCount = 0;

    private int entityNumber;
    private final int maxHp;
    private int hp;
    private int armor;
    private int crit;
    private int critModifier;
    private int attack;
    private boolean wasMoved = false;
    private boolean isAlive = true;

    public abstract void crit(Entity enemy, int critModifier);

    public boolean rollCrit() {
        Random generator = new Random();
        int x = generator.nextInt(100);
        return x < getCrit();
    }

    public void attack(Entity enemy) {
        if (isAlive) {
            if (!checkIfInstanceIsSame(enemy)) {
                if (rollCrit()) {
                    crit(enemy, getCritModifier());
                } else
                    enemy.takeDamage(getAttack());
            }
        }
    }

    public boolean checkIfInstanceIsSame(Entity entity) {
        return this.getClass() == entity.getClass();
    }

    public void takeDamage(int damage) {
        if (isAlive) {
            hp -= (damage - armor / 10);
            isAlive = hp > 0;
            if (!isAlive) {
                if (this instanceof Warrior) {
                    warriorCount--;
                } else if (this instanceof Archer) {
                    archerCount--;
                } else if (this instanceof Mage) {
                    mageCount--;
                }
            }
        }
    }


}
