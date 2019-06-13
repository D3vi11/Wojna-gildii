import java.util.Random;

/**
 *  \class
 *  \brief klasa abstrakcyjna Jednostka
 *
 *  klasa jednostek po której dziedziczą klasy Wojownik, Lucznkik oraz Mag
 */
public abstract class Jednostka implements I_Wspolrzedne,I_Jednostka {


    private int hp; /**< liczba punktów życia */
    private int pancerz;  /**< ilosc pancerza 1 pancerza redukuje podstawowe obrażenia o 0,1% */
    private int wsp_x/**< współrzędna x */, wsp_y; /**< współrzędna y */
    private int kryt; /**< szanse na trafienie krytyczne % (nie wpływa na dodatkowe obrażenia maga) */
    private int mod_kryt; /**< modyfikator trafienia krytycznego jest to liczba przez którą zostaną pomnożone obrażenia w razie trafienia krytycznego */
    private int atak; /**< bazowa wartość ataku */
    private int nr_jednostki; /**< numer jednostki */
    private boolean czy_zywy; /**< flaga stanu życia */


    /**
     *  \brief metoda getNr_jednostki
     *
     * @return metoda zwraca numer jednostki
     */
    @Override
    public int getNr_jednostki() {
        return nr_jednostki;
    }

    /**
     * \brief metoda getCzy_zywy
     *
     * @return metoda zwraca true jeśli obiekt jest żywy i false jeśli obiekt jest martwy
     */
    public boolean getCzy_zywy() {
        return czy_zywy;
    }

    /**
     * \brief metoda setCzy_zywy
     *
     * metoda pozwala zmienić parametr czy_zywy
     * @param czy_zywy zmienna typu boolean na którą zostanie zmieniona oryginalna zmienna czy_zywy
     */
    public void setCzy_zywy(boolean czy_zywy) {
        this.czy_zywy = czy_zywy;
    }

    /**
     * \brief Konstruktor Jednostka
     *
     * konstruktor przy tworzeniu jednostki ustawia jej położenie oraz numer
     * @param wsp_x współrzędna x
     * @param wsp_y współrzędna y
     * @param nr_jednostki numer jednostki
     */
    Jednostka(int wsp_x, int wsp_y, int nr_jednostki)
    {
        this.nr_jednostki=nr_jednostki;
        this.wsp_x=wsp_x;
        this.wsp_y=wsp_y;
    }

    /**
     *  \brief metoda ruch
     *
     *  metoda losuje liczbę z zakresu od 0 do 3 i w zależnosci od wylosowanej liczby zmienia współrzędną x lub y
     *  współrzędne ograniczone są z jednej strony 1 a z drugiej rozmiarem mapy
     * @param rozmiar rozmiar mapy
     */
    @Override
    public void ruch(int rozmiar) {
        Random generator = new Random();
        int r;

            r = generator.nextInt(4);
            switch (r) {
                case 0: {if (wsp_x!=rozmiar)
                    wsp_x++;
                }break;
                case 1:{ if (wsp_x!=1)
                    wsp_x--;
                }break;
                case 2: {if (wsp_y!=rozmiar)
                    wsp_y++;
                }break;
                case 3: {if (wsp_y!=1)
                    wsp_y--;
                }break;
            }
    }

    /**
     * \brief metoda getHp
     *
     * @return zwraca wartosc punktów życia
     */
    @Override
    public int getHp() {
        return hp;
    }

    /**
     * \brief metoda setHp
     *
     * @param hp zmienna na którą zostanie zamieniona oryginalna zmienna hp
     */
    @Override
    public void setHp(int hp) {
        this.hp=hp;
    }

    /**
     * \brief metoda getPancerz
     *
     * @return metoda zwraca wartość pancerza
     */
    @Override
    public int getPancerz() {
        return pancerz;
    }

    /**
     * \brief metoda setPancerz
     *
     * @param pancerz zmienna na którą zostanie zamieniona oryginalna zmienna pancerz
     */
    @Override
    public void setPancerz(int pancerz) {
        this.pancerz=pancerz;
    }


    /**
     * \brief metoda getAtak
     *
     * @return zwraca wartość ataku
     */
    @Override
    public int getAtak() {
        return atak;
    }

    /**
     * \brief metoda setAtak
     *
     * @param atak zmienna na którą zostanie zamieniona oryginalna zmienna atak
     */
    @Override
    public void setAtak(int atak) {
        this.atak=atak;
    }

    /**
     * \brief metoda getKryt
     *
     * @return zwraca szanse na trafienie krytyczne w procentach
     */
    @Override
    public int getKryt() {
        return kryt;
    }

    /**
     * \brief metoda setKryt
     *
     * @param kryt zmienna na którą zostanie zamieniona oryginalna zmienna kryt
     */
    @Override
    public void setKryt(int kryt) {
        this.kryt=kryt;
    }

    /**
     * \brief metoda getMod_kryt
     *
     * @return zwraca modyfikator trafienia krytycznego
     */
    @Override
    public int getMod_kryt() {
        return mod_kryt;
    }

    /**
     * \brief metoda setMod_kryt
     *
     * @param mod_kryt zmienna na którą zostanie zamieniona oryginalna zmienna mod_kryt
     */
    @Override
    public void setMod_kryt(int mod_kryt) {
        this.mod_kryt=mod_kryt;
    }

    /**
     * \brief metoda getWsp_x
     *
     * @return zwraca współrzędną x
     */
    @Override
    public int getWsp_x() {
        return wsp_x;
    }

    /**
     * \brief metoda getWsp_y
     *
     * @return zwraca wspórzędną y
     */
    @Override
    public int getWsp_y() {
        return wsp_y;
    }

    /**
     * \brief metoda abstrakcyjna kryt
     *
     * ciało metody zostało zaimplementowane w klasach Wojownik, Lucznik oraz Mag
     * @param wrog obiekt na którym zostanie wykonana operacja zadania obrażeń krytycznych
     * @param mod_kryt modyfikator trafienia krytycznego
     */
    public abstract void kryt(Jednostka wrog, int mod_kryt);

    /**
     * \brief metoda smierc
     *
     * metoda przyjmuje punkty zdrowia jednostki i jeśli punkty spadną do zera to zmienia flagę czy_zywy na false
     * @param hp aktualna wartosc punktów życia jednostki
     */
    void smierc(int hp)
    {
        if(hp<=0) czy_zywy=false;
        else czy_zywy=true;
    }


}
