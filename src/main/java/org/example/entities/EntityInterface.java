package org.example.entities;

public interface EntityInterface {

    void attack(EntityInterface enemy);

    int getHp();

    void setHp(int hp);

    int getArmor();

    void setArmor(int armor);

    int getAttack();

    void setAttack(int attack);

    int getCrit();

    void setCrit(int crit);

    int getCritModifier();

    void setCritModifier(int critModifier);

    boolean getAlive();

    void setAlive(boolean alive);

    int getEntityNumber();

    boolean getCriticalStrikeChance();

    void death(int hp);

}
