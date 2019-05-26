public class Wojownik extends Jednostka {


    public Wojownik(String name)
    {
        setAtak(100);
        setHp(1000);
        setNazwa(name);
        //setNr_pola();
        setPancerz(100);
        setPredkosc_ruchu(100);
        setZasieg_ataku(1);
    }

    @Override
    public void atak() {

    }

    @Override
    public void kryt() {

    }
}
