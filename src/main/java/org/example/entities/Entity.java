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
    public abstract void crit(Entity enemy, int critModifier);
    public void death() {
        isAlive = hp > 0;
    }

    public boolean rollCrit() {
        Random generator = new Random();
        int x = generator.nextInt(100);
        return x < getCrit();
    }
    public void attack(Entity enemy){
        if (checkInstance(enemy)) {
            if (rollCrit()) {
                crit(enemy, getCritModifier());
            } else
                enemy.takeDamage(getAttack());
        }
    }

    //zwraca true jeśli jednostki są tym samym typem i false jeśli nie są
    public boolean checkInstance(Entity entity) {
        return this.getClass()==entity.getClass();
    }

    public void takeDamage(int damage){
        hp-=(damage-armor/10);
        death();
    }


}
