/**
 *  \interface I_Jednostka
 *  interfejs I_Jednostka
 *
 *  interfejs zawierający metody używane w klasie Jednostka
 */
public interface I_Jednostka {
    /**
     *  metoda ruch
     *
     *  metoda losuje liczbę z zakresu od 0 do 3 i w zależnosci od wylosowanej liczby zmienia współrzędną x lub y
     *  współrzędne ograniczone są z jednej strony 1 a z drugiej rozmiarem mapy
     * @param rozmiar rozmiar mapy
     */
    void ruch(int rozmiar);

    /**
     * metoda atak
     *
     * metoda odbiera punkty zdrowia wrogowi w zależności od punktów ataku
     * @param wrog obiekt któremu zostanią odebrane punkty zdrowia
     */
    void atak(Jednostka wrog);
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
    int getPancerz();
    /**
     * metoda setPancerz
     *
     * @param pancerz zmienna na którą zostanie zamieniona oryginalna zmienna pancerz
     */
    void setPancerz(int pancerz);
    /**
     * metoda getAtak
     *
     * @return zwraca wartość ataku
     */
    int getAtak();
    /**
     * metoda setAtak
     *
     * @param atak zmienna na którą zostanie zamieniona oryginalna zmienna atak
     */
    void setAtak(int atak);
    /**
     * metoda getKryt
     *
     * @return zwraca szanse na trafienie krytyczne w procentach
     */
    int getKryt();
    /**
     * metoda setKryt
     *
     * @param kryt zmienna na którą zostanie zamieniona oryginalna zmienna kryt
     */
    void setKryt(int kryt);
    /**
     * metoda getMod_kryt
     *
     * @return zwraca modyfikator trafienia krytycznego
     */
    int getMod_kryt();
    /**
     * metoda setMod_kryt
     *
     * @param mod_kryt zmienna na którą zostanie zamieniona oryginalna zmienna mod_kryt
     */
    void setMod_kryt(int mod_kryt);
    /**
     * metoda getCzy_zywy
     *
     * @return metoda zwraca true jeśli obiekt jest żywy i false jeśli obiekt jest martwy
     */
    boolean getCzy_zywy();
    /**
     * metoda setCzy_zywy
     *
     * metoda pozwala zmienić parametr czy_zywy
     * @param czy_zywy zmienna typu boolean na którą zostanie zmieniona oryginalna zmienna czy_zywy
     */
    void setCzy_zywy(boolean czy_zywy);
    /**
     * metoda getNr_jednostki
     *
     * @return metoda zwraca numer jednostki
     */
    int getNr_jednostki();

    /**
     * metoda losuj_kryt
     *
     * metoda losuje liczbę od 0 do 99 i sprawdza czy dana liczba to trafienie krytyczne
     * im większa szansa na trafienie krytyczne tym większy zakres liczb uruchomi to trafienie
     * @return zwraca true jeśli trafienie krytyczne i false jeśli nie
     */
    boolean losuj_kryt();

}
