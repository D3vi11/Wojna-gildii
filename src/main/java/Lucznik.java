import java.util.Random;

/**
 * \brief klasa Lucznik
 *
 * klasa łuczników dziedzicząca po klasie jednostek
 */
public class Lucznik extends Jednostka {

    /**
     * \brief konstruktor klasy Lucznik
     *
     * konstruktor ustawia współrzędne, numer jednostki a także statystyki jednostek w tej gildii
     * @param wsp_x współrzędna x
     * @param wsp_y współrzędna y
     * @param nr_jednostki numer jednostki
     */
    Lucznik(int wsp_x, int wsp_y, int nr_jednostki)
    {
        super(wsp_x,wsp_y,nr_jednostki);
        setAtak(90);
        setHp(800);
        setPancerz(60);
        setKryt(30);
        setMod_kryt(3);
        setCzy_zywy(true);
    }

    /**
     * \brief metoda atak
     *
     * metoda odbiera punkty zdrowia wrogowi w zależności od punktów ataku
     * @param wrog obiekt któremu zostanią odebrane punkty zdrowia
     */
    @Override
    public void atak(Jednostka wrog) {
        if (losuj_kryt()) {
            kryt(wrog,getMod_kryt());
        } else
        wrog.setHp((wrog.getHp()-getAtak())+wrog.getPancerz()/10);
        wrog.smierc(wrog.getHp());

    }

    /**
     * \brief metoda kryt
     *
     * metoda mnoży obrazenia
     * @param wrog obiekt na którym zostanie wykonana operacja zadania obrażeń krytycznych
     * @param mod_kryt modyfikator trafienia krytycznego
     */
    @Override
    public void kryt(Jednostka wrog,int mod_kryt) {
        wrog.setHp((wrog.getHp() - mod_kryt * getAtak()) + wrog.getPancerz() / 10);
        if (wrog.getAtak() >= 10) wrog.setAtak(wrog.getAtak() - 5);
    }

    /**
     * \brief metoda losuj_kryt
     *
     * metoda losuje liczbę od 0 do 99 i sprawdza czy dana liczba to trafienie krytyczne
     * im większa szansa na trafienie krytyczne tym większy zakres liczb uruchomi to trafienie
     * @return zwraca true jeśli trafienie krytyczne i false jeśli nie
     */
    @Override
    public boolean losuj_kryt() {
        Random generator=new Random();
        int x = generator.nextInt(100);
        if(x>=0&&x<getKryt())
            return true;
        else return false;
    }
}

