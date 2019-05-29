public class Wynik {
    public static void zlicz_wojownik(int ilosc_jednostek, int T[]){
        int ilosc_zywych=0;
        for(int i=1; i<=ilosc_jednostek; i++)
        {
            T[i].wynik_Hp();
        }

    }

    public static void zlicz_łucznik(int ilosc_jednostek, int T[]) {
        for (int i = 1; i <= ilosc_jednostek; i++)
        {
            T[i].wynik_Hp();
        }
    }

    public static void zlicz_mag(int ilosc_jednostek, int T[]) {
        for (int i = 1; i <= ilosc_jednostek; i++)
        {
            T[i].wynik_Hp();
        }
    }

    public void wynik_Hp(boolean czy_zywy, int ilosc_zycia, int numer_jednostki){
        if(czy_zywy==false) {
            System.out.println("Jednostka zginela.");
        }
            else System.out.println("Jednostce zostalo " + " punktow zycia");
    }

    public void get_Ilosc_jednostek(int ilosc_jednostek, int numer_gildii){
        System.out.println("Ilosc żywych jednostek z gildii" + numer_gildii + " = " + ilosc_jednostek);
    }

}
