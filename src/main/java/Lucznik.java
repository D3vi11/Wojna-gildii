
/**
 * \class Lucznik
 * klasa Lucznik
 *
 * klasa łuczników dziedzicząca po klasie jednostek
 */
public class Lucznik extends Jednostka {

    /**
     * konstruktor klasy Lucznik
     *
     * konstruktor ustawia współrzędne, numer jednostki a także statystyki jednostek w tej gildii
     * @param nr_jednostki numer jednostki
     */
    Lucznik(int nr_jednostki)
    {
        super(nr_jednostki);
        setAtak(70);
        setHp(800);
        setPancerz(60);
        setKryt(30);
        setMod_kryt(3);
        setCzy_zywy(true);
    }

    /**
     *  metoda atak
     *
     * metoda odbiera punkty zdrowia wrogowi w zależności od punktów ataku
     * @param wrog obiekt któremu zostanią odebrane punkty zdrowia
     */
    @Override
    public void atak(I_Jednostka wrog) {
        if(!checkInstance(wrog)) {
            if (losuj_kryt()) {
                kryt(wrog, getMod_kryt());
            } else
                wrog.setHp((wrog.getHp() - getAtak()) + wrog.getPancerz() / 10);
            wrog.smierc(wrog.getHp());
        }

    }

    /**
     *  metoda kryt
     *
     * metoda mnoży obrazenia
     * @param wrog obiekt na którym zostanie wykonana operacja zadania obrażeń krytycznych
     * @param mod_kryt modyfikator trafienia krytycznego
     */
    @Override
    public void kryt(I_Jednostka wrog,int mod_kryt) {
        wrog.setHp((wrog.getHp() - mod_kryt * getAtak()) + wrog.getPancerz() / 10);
        if (wrog.getAtak() >= 10) wrog.setAtak(wrog.getAtak() - 5);
    }

    /**
     *  metoda losuj_kryt
     *
     * metoda losuje liczbę od 0 do 99 i sprawdza czy dana liczba to trafienie krytyczne
     * im większa szansa na trafienie krytyczne tym większy zakres liczb uruchomi to trafienie
     * @return zwraca true jeśli trafienie krytyczne i false jeśli nie
     */
}

