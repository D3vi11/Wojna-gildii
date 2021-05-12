
/**
 * \class Mag
 *  klasa Mag
 *
 *  klasa magów dziedzicząca po klasie Jednostka
 */
public class Mag extends Jednostka {

    /**
     *
     *  konstruktor klasy Mag
     *
     * konstruktor ustawia współrzędne, numer jednostki a także statystyki jednostek w tej gildii
     * @param nr_jednostki numer jednostki
     */
    Mag(int nr_jednostki)
    {
        super(nr_jednostki);
        setAtak(80);
        setHp(700);
        setPancerz(40);
        mana=200;
        obr_many=30;
        setKryt(25);
        setMod_kryt(2);
        setCzy_zywy(true);
    }

    private int mana; /**< aktualne punkty many */
    private int obr_many; /**< dodatkowe obrażenia jakie zada mag gdy ma mane */

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
            } else {
                if (mana == 0) {
                    wrog.setHp((wrog.getHp() - getAtak()) + wrog.getPancerz() / 10);
                } else {
                    wrog.setHp(wrog.getHp() - (getAtak() + obr_many) + getPancerz() / 10);
                    mana -= 10;
                }

            }
            wrog.smierc(wrog.getHp());
        }
    }

    /**
     *  metoda kryt
     *
     * metoda mnoży obrażenia
     * @param wrog obiekt na którym zostanie wykonana operacja zadania obrażeń krytycznych
     * @param mod_kryt modyfikator trafienia krytycznego
     */
    @Override
    public void kryt(I_Jednostka wrog,int mod_kryt) {
            if (mana == 0) {
                wrog.setHp((wrog.getHp() - mod_kryt * getAtak() + wrog.getPancerz() / 10));
            } else {
                wrog.setHp(wrog.getHp() - (mod_kryt * getAtak() + obr_many) + getPancerz() / 10);
                mana -= 10;
            }
    }

    /**
     * metoda losuj_kryt
     *
     * metoda losuje liczbę od 0 do 99 i sprawdza czy dana liczba to trafienie krytyczne
     * im większa szansa na trafienie krytyczne tym większy zakres liczb uruchomi to trafienie
     * @return zwraca true jeśli trafienie krytyczne i false jeśli nie
     *
     */

}
