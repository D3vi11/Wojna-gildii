package org.example.entities;

import lombok.Data;
import lombok.NonNull;

import java.util.Random;

@Data
public abstract class Entity {

    @NonNull
    private final int entityNumber;
    private int hp;
    private int armor;
    private int crit;
    private int critModifier;
    private int attack;
    private boolean isAlive=true;

    public Entity(int entityNumber) {
        this.entityNumber = entityNumber;
    }
    public abstract void attack(Entity enemy);
    public abstract void crit(Entity enemy, int critModifier);
    public void death(int hp) {
        isAlive = hp > 0;
    }

    public boolean rollCrit() {
        Random generator = new Random();
        int x = generator.nextInt(100);
        return x < getCrit();
    }

    //zwraca true jeśli jednostki są tym samym typem i false jeśli nie są
    protected boolean checkInstance(Entity entity) {
        boolean warrior = false, archer = false, mage = false;
        boolean warrior2 = false, archer2 = false, mage2 = false;
        if (this instanceof Warrior) {
            warrior = true;
        }
        if (this instanceof Archer) {
            archer = true;
        }
        if (this instanceof Mage) {
            mage = true;
        }
        if (entity instanceof Warrior) {
            warrior2 = true;
        }
        if (entity instanceof Archer) {
            archer2 = true;
        }
        if (entity instanceof Mage) {
            mage2 = true;
        }
        if (warrior && warrior2 || archer && archer2 || mage && mage2)
            return true;
        else return false;
    }


}
