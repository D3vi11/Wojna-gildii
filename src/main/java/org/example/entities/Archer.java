package org.example.entities;

/**
 * \class Lucznik
 * klasa Lucznik
 *
 * klasa łuczników dziedzicząca po klasie jednostek
 */
public class Archer extends Entity {

    /**
     * konstruktor klasy Lucznik
     *
     * konstruktor ustawia współrzędne, numer jednostki a także statystyki jednostek w tej gildii
     * @param entityNumber numer jednostki
     */
    public Archer(int entityNumber)
    {
        super(entityNumber);
        setAttack(70);
        setHp(800);
        setArmor(60);
        setCrit(30);
        setCritModifier(3);
        setAlive(true);
    }

    /**
     *  metoda atak
     *
     * metoda odbiera punkty zdrowia wrogowi w zależności od punktów ataku
     * @param enemy obiekt któremu zostanią odebrane punkty zdrowia
     */
    @Override
    public void attack(EntityInterface enemy) {
        if(!checkInstance(enemy)) {
            if (getCriticalStrikeChance()) {
                crit(enemy, getCritModifier());
            } else
                enemy.setHp((enemy.getHp() - getAttack()) + enemy.getArmor() / 10);
            enemy.death(enemy.getHp());
        }

    }

    /**
     *  metoda kryt
     *
     * metoda mnoży obrazenia
     * @param enemy obiekt na którym zostanie wykonana operacja zadania obrażeń krytycznych
     * @param critModifier modyfikator trafienia krytycznego
     */
    @Override
    public void crit(EntityInterface enemy, int critModifier) {
        enemy.setHp((enemy.getHp() - critModifier * getAttack()) + enemy.getArmor() / 10);
        if (enemy.getAttack() >= 10) enemy.setAttack(enemy.getAttack() - 5);
    }
}

