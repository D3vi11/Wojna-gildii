package org.example;

import java.util.Random;

/**
 *  \class Jednostka
 *  klasa abstrakcyjna Jednostka
 *
 *  klasa jednostek po której dziedziczą klasy Wojownik, Lucznkik oraz Mag
 */
public abstract class Jednostka implements I_Jednostka {


    private int hp; /**< liczba punktów życia */
    private int pancerz;  /**< ilosc pancerza 1 pancerza redukuje podstawowe obrażenia o 0,1% */
    private int kryt; /**< szanse na trafienie krytyczne % (nie wpływa na dodatkowe obrażenia maga) */
    private int mod_kryt; /**< modyfikator trafienia krytycznego jest to liczba przez którą zostaną pomnożone obrażenia w razie trafienia krytycznego */
    private int atak; /**< bazowa wartość ataku */
    private final int nr_jednostki; /**< numer jednostki */
    private boolean czy_zywy; /**< flaga stanu życia */


    /**
     * metoda getNr_jednostki
     *
     * @return metoda zwraca numer jednostki
     */
    @Override
    public int getNr_jednostki() {
        return nr_jednostki;
    }

    /**
     * metoda getCzy_zywy
     *
     * @return metoda zwraca true jeśli obiekt jest żywy i false jeśli obiekt jest martwy
     */
    @Override
    public boolean getCzy_zywy() {
        return czy_zywy;
    }

    /**
     * metoda setCzy_zywy
     *
     * metoda pozwala zmienić parametr czy_zywy
     * @param czy_zywy zmienna typu boolean na którą zostanie zmieniona oryginalna zmienna czy_zywy
     */
    @Override
    public void setCzy_zywy(boolean czy_zywy) {
        this.czy_zywy = czy_zywy;
    }

    /**
     * Konstruktor Jednostka
     *
     * konstruktor przy tworzeniu jednostki ustawia jej położenie oraz numer
     * @param nr_jednostki numer jednostki
     */
    Jednostka(int nr_jednostki)
    {
        this.nr_jednostki=nr_jednostki;
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
    public int getPancerz() {
        return pancerz;
    }

    /**
     * metoda setPancerz
     *
     * @param pancerz zmienna na którą zostanie zamieniona oryginalna zmienna pancerz
     */
    @Override
    public void setPancerz(int pancerz) {
        this.pancerz=pancerz;
    }


    /**
     * metoda getAtak
     *
     * @return zwraca wartość ataku
     */
    @Override
    public int getAtak() {
        return atak;
    }

    /**
     *  metoda setAtak
     *
     * @param atak zmienna na którą zostanie zamieniona oryginalna zmienna atak
     */
    @Override
    public void setAtak(int atak) {
        this.atak=atak;
    }

    /**
     * metoda getKryt
     *
     * @return zwraca szanse na trafienie krytyczne w procentach
     */
    @Override
    public int getKryt() {
        return kryt;
    }

    /**
     *  metoda setKryt
     *
     * @param kryt zmienna na którą zostanie zamieniona oryginalna zmienna kryt
     */
    @Override
    public void setKryt(int kryt) {
        this.kryt=kryt;
    }

    /**
     * metoda getMod_kryt
     *
     * @return zwraca modyfikator trafienia krytycznego
     */
    @Override
    public int getMod_kryt() {
        return mod_kryt;
    }

    /**
     * metoda setMod_kryt
     *
     * @param mod_kryt zmienna na którą zostanie zamieniona oryginalna zmienna mod_kryt
     */
    @Override
    public void setMod_kryt(int mod_kryt) {
        this.mod_kryt=mod_kryt;
    }


    /**
     * metoda abstrakcyjna kryt
     *
     * ciało metody zostało zaimplementowane w klasach Wojownik, Lucznik oraz Mag
     * @param wrog obiekt na którym zostanie wykonana operacja zadania obrażeń krytycznych
     * @param mod_kryt modyfikator trafienia krytycznego
     */
    public abstract void kryt(I_Jednostka wrog, int mod_kryt);

    /**
     * metoda smierc
     *
     * metoda przyjmuje punkty zdrowia jednostki i jeśli punkty spadną do zera to zmienia flagę czy_zywy na false
     * @param hp aktualna wartosc punktów życia jednostki
     */

    @Override
    public void smierc(int hp)
    {
        czy_zywy = hp > 0;
    }

    @Override
    public boolean losuj_kryt() {
        Random generator=new Random();
        int x = generator.nextInt(100);
        return x < getKryt();
    }
    //zwraca true jeśli jednostki są tym samym typem i false jeśli nie są
    protected boolean checkInstance(I_Jednostka jednostka){
        boolean woj = false, luk = false, m = false;
        boolean woj2 = false, luk2 = false, m2 = false;
        if(this instanceof Wojownik){
            woj = true;
        }
        if(this instanceof Lucznik){
            luk = true;
        }
        if(this instanceof Mag){
            m = true;
        }
        if(jednostka instanceof Wojownik){
            woj2 = true;
        }
        if(jednostka instanceof Lucznik){
            luk2 = true;
        }
        if(jednostka instanceof Mag){
            m2 = true;
        }
        if(woj && woj2 || luk && luk2 || m && m2 )
        return true;
        else return false;
    }

}
