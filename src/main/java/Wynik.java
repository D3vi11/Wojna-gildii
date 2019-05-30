class Wynik {
     void zlicz_wojownik(int liczba_jednostek, Wojownik[] T){
        int ilosc_zywych=liczba_jednostek;
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(!T[i].getCzy_zywy()) ilosc_zywych--;
        }
        System.out.println("Gildia wojownikow:" + ilosc_zywych);
        System.out.println("Ilosc zywych jednostek=" + ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        System.out.println("Ilosc martwych jednostek=" + ilosc_martwych);
    }

     void zlicz_lucznik(int liczba_jednostek, Lucznik[] T) {
        int ilosc_zywych=liczba_jednostek;
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(!T[i].getCzy_zywy()) ilosc_zywych--;
        }
        System.out.println("Gildia lucznikow:" + ilosc_zywych);
        System.out.println("Ilosc zywych jednostek=" + ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        System.out.println("Ilosc martwych jednostek=" + ilosc_martwych);
    }

     void zlicz_mag(int liczba_jednostek, Mag[] T) {
        int ilosc_zywych=liczba_jednostek;
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(!T[i].getCzy_zywy()) ilosc_zywych--;
        }
        System.out.println("Gildia magow:" + ilosc_zywych);
        System.out.println("Ilosc zywych jednostek=" + ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        System.out.println("Ilosc martwych jednostek=" + ilosc_martwych);
    }

    void jednostki_wojownik(int liczba_jednostek, Wojownik[] T){
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) System.out.println("Jednostce z gildii wojownikow nr " + T[i].getNr_jednostki() + "zostalo " + T[i].getHp() + "punktow zdrowia.");
        }
    }

    void jednostki_lucznik(int liczba_jednostek, Lucznik[] T){
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) System.out.println("Jednostce z gildii lucznikow nr " + T[i].getNr_jednostki() + "zostalo " + T[i].getHp() + "punktow zdrowia.");
        }
    }

    void jednostki_mag(int liczba_jednostek, Mag[] T){
        for(int i=0; i<liczba_jednostek; i++)
        {
            if(T[i].getCzy_zywy()) System.out.println("Jednostce z gildii magow nr " + T[i].getNr_jednostki() + "zostalo " + T[i].getHp() + "punktow zdrowia.");
        }
    }
}
