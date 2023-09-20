package org.example.entities;

import java.util.Random;

public abstract class Entity implements EntityInterface {


    private int hp;
    private int armor;
    private int crit;
    private int critModifier;
    private int attack;
    private final int entityNumber;
    private boolean isAlive;

    @Override
    public int getEntityNumber() {
        return entityNumber;
    }

    @Override
    public boolean getAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    Entity(int entityNumber) {
        this.entityNumber = entityNumber;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public int getCrit() {
        return crit;
    }

    @Override
    public void setCrit(int crit) {
        this.crit = crit;
    }

    @Override
    public int getCritModifier() {
        return critModifier;
    }

    @Override
    public void setCritModifier(int critModifier) {
        this.critModifier = critModifier;
    }

    public abstract void crit(EntityInterface wrog, int mod_kryt);

    @Override
    public void death(int hp) {
        isAlive = hp > 0;
    }

    @Override
    public boolean getCriticalStrikeChance() {
        Random generator = new Random();
        int x = generator.nextInt(100);
        return x < getCrit();
    }

    //zwraca true jeśli jednostki są tym samym typem i false jeśli nie są
    protected boolean checkInstance(EntityInterface entity) {
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
