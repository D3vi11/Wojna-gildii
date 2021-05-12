
/**
 * \class Wojownik
 *  Klasa jednostek z gildii wojownokow.
 *
 *  Klasa wojownik. Dzidziczy po klasie jednostka. Zwiera atrybuty i metody przypisane wowjownikowi.
 */

public class Wojownik extends Jednostka {

    /**
     * Konstruktor klasy Wojownik
     *
     * nadpisuje satystyki wojownika o danym numerze na polu o dancyh wspolrzednych takie jak atak, punkty Hp, pancerz, obrazenia krytyczne modyfikator trafienia krytycznego. ustania równiez na początku stan wojownika na zywy.
     *
     * @param nr_jednostki parametr zawierajacy numer jednostki.
     */

    Wojownik(int nr_jednostki)
    {
        super(nr_jednostki);
        setAtak(65);
        setHp(1000);
        setPancerz(70);
        setKryt(35);
        setMod_kryt(2);
        setCzy_zywy(true);
    }

    /**
     *  Metoda okresla atak.
     *
     * Metoda ustala wielkosc ataku oraz obrazzenia krytyczne.
     *
     * @param wrog obiekt ktoremu zostanią odebrane punkty zdrowia
     */

    @Override
    public void atak(I_Jednostka wrog) {
        if(!checkInstance(wrog)) {
            if (losuj_kryt())
                kryt(wrog, getMod_kryt());
            else
                wrog.setHp((wrog.getHp() - getAtak()) + wrog.getPancerz() / 10);
            wrog.smierc(wrog.getHp());
        }
    }

    /**
     * Metoda okresla obrazenia krytyczne.
     *
     * Metoda okresla wielkosc obrazen krytycznych wojownika oraz modyfikator trfien krytycznych.
     *
     * @param wrog obiekt na ktorym zostanie wykonana operacja zadania obrażeń krytycznych
     * @param mod_kryt modyfikator trafienia krytycznego
     */

    @Override
    public void kryt(I_Jednostka wrog,int mod_kryt) {
            wrog.setHp((wrog.getHp()-mod_kryt*getAtak())+wrog.getPancerz()/10);
    }

    /**
     * Metoda losujaca obrazenia krytyczne.
     *
     * Metoda w sposob losowy okresla czy obrazenia krytyczne maja wystapic u wojownika.
     *
     * @return czy uzyc obrazen krytycznych
     */
}
