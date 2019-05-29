public class Wynik {

    public void get_Hp(boolean czy_zywy, int ilosc_zycia){
        if(czy_zywy==false) {
            System.out.println("Jednostka jest zginela.");
        }
            else System.out.println("Jednostce zostalo " + " punktow zycia");
    }

    public void get_Ilosc_jednostek(int ilosc_jednostek, String nazwa_gildii){
        System.out.println("Ilosc żywych jednostek z gildii" + nazwa_gildii + " = " + ilosc_jednostek);
    }

}
