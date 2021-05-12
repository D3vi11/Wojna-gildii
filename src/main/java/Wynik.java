import java.io.PrintWriter;

/**
 * \class Wynik
 * Klasa licząca i wypisująca wyniki.
 *
 * Klasa pobiera dane opisujące stan gildii oraz poszczegolnych jednostek i wypisuje je w wynikach.
 */

class Wynik {

    private int wojownicy; /**< Zmienna przechowuje dane na temat liczby zywych wojownikow. */
    private int lucznicy;  /**< Zmienna przechowuje dane na temat liczby zywych lucznikow. */
    private int magowie;   /**< Zmienna przechowuje dane na temat liczby zywych magow. */

    /**
     * Metoda zlicza liczbe zywych wojownikow.
     *
     * Metoda pobiera poczatkowa liczbe jednostek zadana przez uzytkownika oraz tablice przechowujaca obiekty z klasy wojownik i zlicza liczbe zywych jednostek z tej gildii.
     *
     * @param liczba_jednostek parametr przechowuje ilosc jednostek zadanych na starcie przez uzytkownika.
     */

     void zlicz(int liczba_jednostek,Pole [][] pole, int rozmiar){
        int iloscZywychW=liczba_jednostek;
        int iloscZywychL=liczba_jednostek;
        int iloscZywychM=liczba_jednostek;
        for(int i=0; i<rozmiar;i++)
            for (int j = 0;j<rozmiar;j++)
                for(I_Jednostka jednostka:pole[i][j].get_list())
                    {
                         if(!jednostka.getCzy_zywy() && jednostka instanceof Wojownik) iloscZywychW--;
                         if(!jednostka.getCzy_zywy() && jednostka instanceof Lucznik) iloscZywychL--;
                         if(!jednostka.getCzy_zywy() && jednostka instanceof Mag) iloscZywychM--;
                    }

        wojownicy=iloscZywychW;
        lucznicy = iloscZywychL;
        magowie = iloscZywychM;
    }


    /**
     *  Metoda zapisuje wyniki w pliku.
     *
     *  Metoda zapisuje paramtry w pliku. Wypisyje liczbe zywych jednotsek, liczbe martwych jednostek oraz ilosc Hp i polozenie kazdej jednostki.
     *
     * @param liczba_jednostek  parametr przechowuje ilosc jednostek zadanych na starcie przez uzytkownika.
     * @param wyniki obiekt umozliwiajacy zapisanie wynikow  w pliku
     */

    public void zapisz_wyniki(int liczba_jednostek, int iloscZywychWojownikow,int iloscZywychLucznikow, int iloscZywychMagow, PrintWriter wyniki, Mapa mapa){
        int ilosc_martwychW=liczba_jednostek-iloscZywychWojownikow;
        int ilosc_martwychL=liczba_jednostek-iloscZywychLucznikow;
        int ilosc_martwychM=liczba_jednostek-iloscZywychMagow;
        wyniki.println( "Liczba jednostek gildii wojownikow: " + liczba_jednostek);
        wyniki.println("Ilosc zywych jednostek = " + iloscZywychWojownikow);
        wyniki.println("Ilosc martwych jednostek = " + ilosc_martwychW);
        wyniki.println( "Liczba jednostek gildii łuczników: " + liczba_jednostek);
        wyniki.println("Ilosc zywych jednostek = " + iloscZywychLucznikow);
        wyniki.println("Ilosc martwych jednostek = " + ilosc_martwychL);
        wyniki.println( "Liczba jednostek gildii magów: " + liczba_jednostek);
        wyniki.println("Ilosc zywych jednostek = " + iloscZywychMagow);
        wyniki.println("Ilosc martwych jednostek = " + ilosc_martwychM);

        for(int i=0;i<mapa.getRozmiar();i++){
            for(int j=0;j<mapa.getRozmiar();j++){
                for(int k=0;k<mapa.getPole(i,j).get_list().size();k++){
                    if(mapa.getPole(i,j).getUnit(k).getCzy_zywy()) {
                        if (mapa.getPole(i, j).getUnit(k) instanceof Wojownik)
                            wyniki.println("Jednostka z gildii wojowników nr " + mapa.getPole(i, j).getUnit(k).getNr_jednostki() + " jest na polu x: " + mapa.getPole(i, j).getWsp_x() + " y: " + mapa.getPole(i, j).getWsp_y());
                        if (mapa.getPole(i, j).getUnit(k) instanceof Lucznik)
                            wyniki.println("Jednostka z gildii luczników nr " + mapa.getPole(i, j).getUnit(k).getNr_jednostki() + " jest na polu x: " + mapa.getPole(i, j).getWsp_x() + " y: " + mapa.getPole(i, j).getWsp_y());
                        if (mapa.getPole(i, j).getUnit(k) instanceof Mag)
                            wyniki.println("Jednostka z gildii Magów nr " + mapa.getPole(i, j).getUnit(k).getNr_jednostki() + " jest na polu x: " + mapa.getPole(i, j).getWsp_x() + " y: " + mapa.getPole(i, j).getWsp_y());
                    }
                }
             }
        }
    }

    /**
     * Metoda zwraca aktualna liczbe zywych wojownikow.
     * @return aktualna liczbe zywych wojownikow.
     */
    int getWojownicy() {
        return wojownicy;
    }

    /**
     *  Metoda zwraca aktualna liczbe zywych wojownikow.
     * @return aktualna liczbe zywych lucznikow.
     */

    int getLucznicy() {
        return lucznicy;
    }

    /**
     * Metoda zwraca aktualna liczbe zywych wojownikow.
     * @return aktualna liczbe zywych magow.
     */

    int getMagowie() {
        return magowie;
    }
    public BoolString zwyciestwo(int liczba_jednostek, BoolString napis, Pole [][] pole, int rozmiar){

        zlicz(liczba_jednostek, pole, rozmiar);
        if(wojownicy==0&&lucznicy==0) {
            napis.setNapis("WYGRALI MAGOWIE");
            napis.setX(true);
            return napis;
        }
        if(wojownicy==0&&magowie==0)
        {
            napis.setNapis("WYGRALI LUCZNICY");
            napis.setX(true);
            return napis;
        }
        if(lucznicy==0&&magowie==0)
        {
            napis.setNapis("WYGRALI WOJOWNICY");
            napis.setX(true);
            return napis;
        }
        napis.setX(false);
        napis.setNapis("WALKA NIEROZSTRZYGNIĘTA");
        return napis;
    }
}
