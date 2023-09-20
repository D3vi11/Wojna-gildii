package org.example;

/**
 *  \interface I_Jednostka
 *  interfejs I_Jednostka
 *
 *  interfejs zawierający metody używane w klasie Jednostka
 */
public interface EntityInterface {
    /**
     * metoda atak
     *
     * metoda odbiera punkty zdrowia wrogowi w zależności od punktów ataku
     * @param enemy obiekt któremu zostanią odebrane punkty zdrowia
     */
    void attack(EntityInterface enemy);
    /**
     * metoda getHp
     *
     * @return zwraca wartosc punktów życia
     */
    int getHp();
    /**
     * metoda setHp
     *
     * @param hp zmienna na którą zostanie zamieniona oryginalna zmienna hp
     */
    void setHp(int hp);
    /**
     * metoda getPancerz
     *
     * @return metoda zwraca wartość pancerza
     */
    int getArmor();
    /**
     * metoda setPancerz
     *
     * @param armor zmienna na którą zostanie zamieniona oryginalna zmienna pancerz
     */
    void setArmor(int armor);
    /**
     * metoda getAtak
     *
     * @return zwraca wartość ataku
     */
    int getAttack();
    /**
     * metoda setAtak
     *
     * @param attack zmienna na którą zostanie zamieniona oryginalna zmienna atak
     */
    void setAttack(int attack);
    /**
     * metoda getKryt
     *
     * @return zwraca szanse na trafienie krytyczne w procentach
     */
    int getCrit();
    /**
     * metoda setKryt
     *
     * @param crit zmienna na którą zostanie zamieniona oryginalna zmienna kryt
     */
    void setCrit(int crit);
    /**
     * metoda getMod_kryt
     *
     * @return zwraca modyfikator trafienia krytycznego
     */
    int getCritModifier();
    /**
     * metoda setMod_kryt
     *
     * @param critModifier zmienna na którą zostanie zamieniona oryginalna zmienna mod_kryt
     */
    void setCritModifier(int critModifier);
    /**
     * metoda getCzy_zywy
     *
     * @return metoda zwraca true jeśli obiekt jest żywy i false jeśli obiekt jest martwy
     */
    boolean getAlive();
    /**
     * metoda setCzy_zywy
     *
     * metoda pozwala zmienić parametr czy_zywy
     * @param alive zmienna typu boolean na którą zostanie zmieniona oryginalna zmienna czy_zywy
     */
    void setAlive(boolean alive);
    /**
     * metoda getNr_jednostki
     *
     * @return metoda zwraca numer jednostki
     */
    int getEntityNumber();

    /**
     * metoda losuj_kryt
     *
     * metoda losuje liczbę od 0 do 99 i sprawdza czy dana liczba to trafienie krytyczne
     * im większa szansa na trafienie krytyczne tym większy zakres liczb uruchomi to trafienie
     * @return zwraca true jeśli trafienie krytyczne i false jeśli nie
     */
    boolean getCriticalStrikeChance();

    void death(int hp);

}
