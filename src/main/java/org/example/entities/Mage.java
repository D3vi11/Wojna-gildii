package org.example.entities;

/**
 * \class Mag
 *  klasa Mag
 *
 *  klasa magów dziedzicząca po klasie Jednostka
 */
public class Mage extends Entity {

    /**
     *
     *  konstruktor klasy Mag
     *
     * konstruktor ustawia współrzędne, numer jednostki a także statystyki jednostek w tej gildii
     * @param entityNumber numer jednostki
     */
    public Mage(int entityNumber)
    {
        super(entityNumber);
        setAttack(80);
        setHp(700);
        setArmor(40);
        mana=200;
        manaDmg =30;
        setCrit(25);
        setCritModifier(2);
        setAlive(true);
    }

    private int mana; /**< aktualne punkty many */
    private int manaDmg; /**< dodatkowe obrażenia jakie zada mag gdy ma mane */

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

    /**
     *  metoda kryt
     *
     * metoda mnoży obrażenia
     * @param enemy obiekt na którym zostanie wykonana operacja zadania obrażeń krytycznych
     * @param critModifier modyfikator trafienia krytycznego
     */
    @Override
    public void crit(EntityInterface enemy, int critModifier) {
            if (mana == 0) {
                enemy.setHp((enemy.getHp() - critModifier * getAttack() + enemy.getArmor() / 10));
            } else {
                enemy.setHp(enemy.getHp() - (critModifier * getAttack() + manaDmg) + getArmor() / 10);
                mana -= 10;
            }
    }

}
