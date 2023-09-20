package org.example.entities;

import java.util.Random;

public abstract class Entity {


    private int hp;
    private int armor;
    private int crit;
    private int critModifier;
    private int attack;
    private final int entityNumber;
    private boolean isAlive;
    public Entity(int entityNumber) {
        this.entityNumber = entityNumber;
    }
    public abstract void attack(Entity enemy);
    public abstract void crit(Entity enemy, int critModifier);

    public int getEntityNumber() {
        return entityNumber;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getCritModifier() {
        return critModifier;
    }

    public void setCritModifier(int critModifier) {
        this.critModifier = critModifier;
    }

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
