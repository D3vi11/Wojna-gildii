package org.example;

import java.util.Random;

/**
 *  \class Jednostka
 *  klasa abstrakcyjna Jednostka
 *
 *  klasa jednostek po której dziedziczą klasy Wojownik, Lucznkik oraz Mag
 */
public abstract class Entity implements EntityInterface {


    private int hp; /**< liczba punktów życia */
    private int armor;  /**< ilosc pancerza 1 pancerza redukuje podstawowe obrażenia o 0,1% */
    private int crit; /**< szanse na trafienie krytyczne % (nie wpływa na dodatkowe obrażenia maga) */
    private int critModifier; /**< modyfikator trafienia krytycznego jest to liczba przez którą zostaną pomnożone obrażenia w razie trafienia krytycznego */
    private int attack; /**< bazowa wartość ataku */
    private final int entityNumber; /**< numer jednostki */
    private boolean isAlive; /**< flaga stanu życia */


    /**
     * metoda getNr_jednostki
     *
     * @return metoda zwraca numer jednostki
     */
    @Override
    public int getEntityNumber() {
        return entityNumber;
    }

    /**
     * metoda getCzy_zywy
     *
     * @return metoda zwraca true jeśli obiekt jest żywy i false jeśli obiekt jest martwy
     */
    @Override
    public boolean getAlive() {
        return isAlive;
    }

    /**
     * metoda setCzy_zywy
     *
     * metoda pozwala zmienić parametr czy_zywy
     * @param alive zmienna typu boolean na którą zostanie zmieniona oryginalna zmienna czy_zywy
     */
    @Override
    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    /**
     * Konstruktor Jednostka
     *
     * konstruktor przy tworzeniu jednostki ustawia jej położenie oraz numer
     * @param entityNumber numer jednostki
     */
    Entity(int entityNumber)
    {
        this.entityNumber =entityNumber;
    }


    /**
     * metoda getHp
     *
     * @return zwraca wartosc punktów życia
     */
    @Override
    public int getHp() {
        return hp;
    }

    /**
     * metoda setHp
     *
     * @param hp zmienna na którą zostanie zamieniona oryginalna zmienna hp
     */
    @Override
    public void setHp(int hp) {
        this.hp=hp;
    }

    /**
     * metoda getPancerz
     *
     * @return metoda zwraca wartość pancerza
     */
    @Override
    public int getArmor() {
        return armor;
    }

    /**
     * metoda setPancerz
     *
     * @param armor zmienna na którą zostanie zamieniona oryginalna zmienna pancerz
     */
    @Override
    public void setArmor(int armor) {
        this.armor = armor;
    }


    /**
     * metoda getAtak
     *
     * @return zwraca wartość ataku
     */
    @Override
    public int getAttack() {
        return attack;
    }

    /**
     *  metoda setAtak
     *
     * @param attack zmienna na którą zostanie zamieniona oryginalna zmienna atak
     */
    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * metoda getKryt
     *
     * @return zwraca szanse na trafienie krytyczne w procentach
     */
    @Override
    public int getCrit() {
        return crit;
    }

    /**
     *  metoda setKryt
     *
     * @param crit zmienna na którą zostanie zamieniona oryginalna zmienna kryt
     */
    @Override
    public void setCrit(int crit) {
        this.crit = crit;
    }

    /**
     * metoda getMod_kryt
     *
     * @return zwraca modyfikator trafienia krytycznego
     */
    @Override
    public int getCritModifier() {
        return critModifier;
    }

    /**
     * metoda setMod_kryt
     *
     * @param critModifier zmienna na którą zostanie zamieniona oryginalna zmienna mod_kryt
     */
    @Override
    public void setCritModifier(int critModifier) {
        this.critModifier = critModifier;
    }


    /**
     * metoda abstrakcyjna kryt
     *
     * ciało metody zostało zaimplementowane w klasach Wojownik, Lucznik oraz Mag
     * @param wrog obiekt na którym zostanie wykonana operacja zadania obrażeń krytycznych
     * @param mod_kryt modyfikator trafienia krytycznego
     */
    public abstract void crit(EntityInterface wrog, int mod_kryt);

    /**
     * metoda smierc
     *
     * metoda przyjmuje punkty zdrowia jednostki i jeśli punkty spadną do zera to zmienia flagę czy_zywy na false
     * @param hp aktualna wartosc punktów życia jednostki
     */

    @Override
    public void death(int hp)
    {
        isAlive = hp > 0;
    }

    @Override
    public boolean getCriticalStrikeChance() {
        Random generator=new Random();
        int x = generator.nextInt(100);
        return x < getCrit();
    }
    //zwraca true jeśli jednostki są tym samym typem i false jeśli nie są
    protected boolean checkInstance(EntityInterface entity){
        boolean warrior = false, archer = false, mage = false;
        boolean warrior2 = false, archer2 = false, mage2 = false;
        if(this instanceof Warrior){
            warrior = true;
        }
        if(this instanceof Archer){
            archer = true;
        }
        if(this instanceof Mage){
            mage = true;
        }
        if(entity instanceof Warrior){
            warrior2 = true;
        }
        if(entity instanceof Archer){
            archer2 = true;
        }
        if(entity instanceof Mage){
            mage2 = true;
        }
        if(warrior && warrior2 || archer && archer2 || mage && mage2 )
        return true;
        else return false;
    }

}
