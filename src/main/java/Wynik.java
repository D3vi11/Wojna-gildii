public class Wynik {
    public static void zlicz_wojownik(int liczba_jednostek, Wojownik T[]){
        int ilosc_zywych=liczba_jednostek;
        for(int i=1; i<=liczba_jednostek; i++)
        {
            if(T[i].getCzy_żywy()) ilosc_zywych--;
        }
        System.out.println("Gildia wojownikow:"+ilosc_zywych);
        System.out.println("Ilosc zywych jednostek="+ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        System.out.println("Ilosc mertwych jednostek="+ilosc_martwych);
    }

    public static void zlicz_lucznik(int liczba_jednostek, Lucznik T[]) {
        int ilosc_zywych=liczba_jednostek;
        for(int i=1; i<=liczba_jednostek; i++)
        {
            if(T[i].getCzy_żywy()) ilosc_zywych--;
        }
        System.out.println("Gildia lucznikow:"+ilosc_zywych);
        System.out.println("Ilosc zywych jednostek="+ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        System.out.println("Ilosc mertwych jednostek="+ilosc_martwych);
    }

    public static void zlicz_mag(int liczba_jednostek, Mag T[]) {
        int ilosc_zywych=liczba_jednostek;
        for(int i=1; i<=liczba_jednostek; i++)
        {
            if(T[i].getCzy_żywy()) ilosc_zywych--;
        }
        System.out.println("Gildia magow:"+ilosc_zywych);
        System.out.println("Ilosc zywych jednostek="+ilosc_zywych);
        int ilosc_martwych=liczba_jednostek-ilosc_zywych;
        System.out.println("Ilosc mertwych jednostek="+ilosc_martwych);
    }
}