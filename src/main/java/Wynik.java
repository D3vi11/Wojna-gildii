import java.io.PrintWriter;

class Wynik {

    private int wojownicy;
    private int lucznicy;
    private int magowie;

    /**
     * \brief Metoda zlicza liczbe zywych wojownikow.
     *
     * Metoda pobiera poczatkowa ilosc jednostek zadana przez uzytkownika oraz tablice przechowujaca obiekty z klasy wojownik i zlicza liczbe zywych jednostek z tej gildii.
     *
     * @param liczba_jednostek Parametr przechowuje ilosc jednostek zadanych na starcie przez uzytkownika.
     * @param T Tablica przechowujaca jednostki z gildii wojownikow.
     */

     void zlicz_wojownik(int liczba_jednostek, Wojownik[] T){
        int ilosc_zywych=liczba_jednostek;
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(!T[i].getCzy_zywy()) ilosc_zywych--;
        }

        wojownicy=ilosc_zywych;
    }

    /**
     * \brief Metoda zlicza liczbe zywych lucznikow.
     *
     * Metoda pobiera poczatkowa ilosc jednostek zadana przez uzytkownika oraz tablice przechowująca obiekty z klasy lucznik i zlicza liczbe zywych jednostek z tej gildii.
     *
     * @param liczba_jednostek  Parametr przechowuje ilosc jednostek zadanych na starcie przez uzytkownika.
     * @param T Tablica przechowujaca jednostki z gildii lucznikow.
     */

     void zlicz_lucznik(int liczba_jednostek, Lucznik[] T) {
        int ilosc_zywych=liczba_jednostek;
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(!T[i].getCzy_zywy()) ilosc_zywych--;
        }

        lucznicy=ilosc_zywych;
    }

    /**
     * \brief Metoda zlicza liczbe zywych magow.
     *
     *  Metoda pobiera poczatkowa ilosc jednostek zadana przez uzytkownika oraz tablice przechowująca obiekty z klasy magow i zlicza liczbe zywych jednostek z tej gildii.
     *
     * @param liczba_jednostek a
     * @param T  Tablica przechowujaca jednostki z gildii magow.
     */

    void zlicz_mag(int liczba_jednostek, Mag[] T) {
        int ilosc_zywych=liczba_jednostek;
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(!T[i].getCzy_zywy()) ilosc_zywych--;
        }
        magowie=ilosc_zywych;
    }


    /**
     * \brief Metoda wypisuje ilosc punktow Hp wojownika.
     *
     *  Metoda pobiera poczatkowa ilosc jednostek zadana przez uzytkownika oraz tablice przechowujaca obiekty z klasy wojownik oraz po sprawdzeniu metoda getCzy-zywy() czy jednostka zyje wypisuje ilosc jej punktow Hp.
     *
     * @param liczba_jednostek
     * @param T
     */

    void jednostki_wojownik(int liczba_jednostek, Wojownik[] T){
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) System.out.println("Jednostce z gildii wojownikow nr " + T[i].getNr_jednostki() + " zostalo " + T[i].getHp() + " punktow zdrowia.");
        }
    }

    /**
     *  \brief  Metoda wypisuje ilosc punktow Hp lucznika.
     *
     *  Metoda pobiera poczatkowa ilosc jednostek zadana przez uzytkownika oraz tablice przechowujaca obiekty z klasy lucznik oraz po sprawdzeniu metoda getCzy-zywy() czy jednostka zyje wypisuje ilosc jej punktow Hp.
     *
     * @param liczba_jednostek
     * @param T
     */

    void jednostki_lucznik(int liczba_jednostek, Lucznik[] T){
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) System.out.println("Jednostce z gildii lucznikow nr " + T[i].getNr_jednostki() + " zostalo " + T[i].getHp() + " punktow zdrowia.");
        }
    }

    /**
     *
     *
     *
     * @param liczba_jednostek
     * @param T
     */

    void jednostki_mag(int liczba_jednostek, Mag[] T){
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) System.out.println("Jednostce z gildii magow nr " + T[i].getNr_jednostki() + " zostalo " + T[i].getHp() + " punktow zdrowia.");
        }
    }
    void wypiszW(int liczba_jednostek, int ilosc_zywych)
    {
        System.out.println("Liczba jednostek gildii wojownikow: " + liczba_jednostek);
        System.out.println("Ilosc zywych jednostek = " + ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        System.out.println("Ilosc martwych jednostek = " + ilosc_martwych);
    }
    void wypiszL(int liczba_jednostek, int ilosc_zywych)
    {
        System.out.println("Liczba jednostek gildii lucznikow: " + liczba_jednostek);
        System.out.println("Ilosc zywych jednostek = " + ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        System.out.println("Ilosc martwych jednostek = " + ilosc_martwych);
    }

    void wypiszM(int liczba_jednostek, int ilosc_zywych)
    {
        System.out.println("Liczba jednostek gildii magow: " + liczba_jednostek);
        System.out.println("Ilosc zywych jednostek = " + ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        System.out.println("Ilosc martwych jednostek = " + ilosc_martwych);
    }

    void zapisz_wyniki_W(int liczba_jednostek, int ilosc_zywych, PrintWriter wyniki, Wojownik[] T)  {

        wyniki.println( "Liczba jednostek gildii wojownikow: " + liczba_jednostek);
        wyniki.println("Ilosc zywych jednostek = " + ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        wyniki.println("Ilosc martwych jednostek = " + ilosc_martwych);
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) wyniki.println("Jednostka z gildii wojownikow nr " + T[i].getNr_jednostki() + " jest na polu x: " + T[i].getWsp_x() + " y: " + T[i].getWsp_y());
        }
        wyniki.println(" ");
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) wyniki.println("Jednostce z gildii wojownikow nr " + T[i].getNr_jednostki() + " zostalo " + T[i].getHp() + " punktow zdrowia.");
        }
    }
    void zapisz_wyniki_L(int liczba_jednostek, int ilosc_zywych, PrintWriter wyniki, Lucznik[] T)  {

        wyniki.println("Liczba jednostek gildii lucznikow: " + liczba_jednostek);
        wyniki.println("Ilosc zywych jednostek = " + ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        wyniki.println("Ilosc martwych jednostek = " + ilosc_martwych);
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) wyniki.println("Jednostka z gildii lucznikow nr " + T[i].getNr_jednostki() + " jest na polu x: " + T[i].getWsp_x() + " y: " + T[i].getWsp_y());
        }
        wyniki.println(" ");
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) wyniki.println("Jednostce z gildii lucznikow nr " + T[i].getNr_jednostki() + " zostalo " + T[i].getHp() + " punktow zdrowia.");
        }
    }
    void zapisz_wyniki_M(int liczba_jednostek, int ilosc_zywych, PrintWriter wyniki, Mag[] T) {

        wyniki.println("Liczba jednostek gildii magow: " + liczba_jednostek);
        wyniki.println("Ilosc zywych jednostek = " + ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        wyniki.println("Ilosc martwych jednostek = " + ilosc_martwych);
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) wyniki.println("Jednostka z gildii magow nr " + T[i].getNr_jednostki() + " jest na polu x: " + T[i].getWsp_x() + " y: " + T[i].getWsp_y());
        }
        wyniki.println(" ");
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) wyniki.println("Jednostce z gildii magow nr " + T[i].getNr_jednostki() + " zostalo " + T[i].getHp() + " punktow zdrowia.");
        }
    }
    int getWojownicy() {
        return wojownicy;
    }
    int getLucznicy() {
        return lucznicy;
    }

    int getMagowie() {
        return magowie;
    }
}
