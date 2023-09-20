package org.example.entities;

/**
 * \class Wojownik
 *  Klasa jednostek z gildii wojownokow.
 *
 *  Klasa wojownik. Dzidziczy po klasie jednostka. Zwiera atrybuty i metody przypisane wowjownikowi.
 */

public class Warrior extends Entity {

    /**
     * Konstruktor klasy Wojownik
     *
     * nadpisuje satystyki wojownika o danym numerze na polu o dancyh wspolrzednych takie jak atak, punkty Hp, pancerz, obrazenia krytyczne modyfikator trafienia krytycznego. ustania równiez na początku stan wojownika na zywy.
     *
     * @param entityNumber parametr zawierajacy numer jednostki.
     */

    Warrior(int entityNumber)
    {
        super(entityNumber);
        setAttack(65);
        setHp(1000);
        setArmor(70);
        setCrit(35);
        setCritModifier(2);
        setAlive(true);
    }

    /**
     *  Metoda okresla atak.
     *
     * Metoda ustala wielkosc ataku oraz obrazzenia krytyczne.
     *
     * @param enemy obiekt ktoremu zostanią odebrane punkty zdrowia
     */

    @Override
    public void attack(EntityInterface enemy) {
        if(!checkInstance(enemy)) {
            if (getCriticalStrikeChance())
                crit(enemy, getCritModifier());
            else
                enemy.setHp((enemy.getHp() - getAttack()) + enemy.getArmor() / 10);
            enemy.death(enemy.getHp());
        }
    }

    /**
     * Metoda okresla obrazenia krytyczne.
     *
     * Metoda okresla wielkosc obrazen krytycznych wojownika oraz modyfikator trfien krytycznych.
     *
     * @param enemy obiekt na ktorym zostanie wykonana operacja zadania obrażeń krytycznych
     * @param critModifier modyfikator trafienia krytycznego
     */

    @Override
    public void crit(EntityInterface enemy, int critModifier) {
            enemy.setHp((enemy.getHp()-critModifier* getAttack())+enemy.getArmor()/10);
    }

    /**
     * Metoda losujaca obrazenia krytyczne.
     *
     * Metoda w sposob losowy okresla czy obrazenia krytyczne maja wystapic u wojownika.
     *
     * @return czy uzyc obrazen krytycznych
     */
}
