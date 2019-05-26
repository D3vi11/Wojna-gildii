public abstract class Jednostka implements I_Wspolrzedne,I_Jednostka {

    private int hp; // ilosc pkt życia
    private int predkosc_ruchu; // wartosc predkosci ruchu
    private int pancerz;  // ilosc pancerza
    private int zasieg_ataku; // zasieg ataku
    private String nazwa; //nazwa
    private int nr_pola; // nr pola pozwalający sprawdzić czy jednostka jest na odpowiednim polu
    private int kryt; // szanse na trafienie krytyczne (x2)
    private int atak; // bazowa wartość ataku




    @Override
    public void ruch() {

    }

    @Override
    public void atak() {

    }

    @Override
    public boolean czy_spotkanie() {
        return false;
    }

    @Override
    public int getHp() {
        return 0;
    }

    @Override
    public void setHp() {

    }

    @Override
    public int getPredkosc_ruchu() {
        return 0;
    }

    @Override
    public void setPredkosc_ruchu() {

    }

    @Override
    public int getPancerz() {
        return 0;
    }

    @Override
    public void setPancerz() {

    }

    @Override
    public int getZasieg_ataku() {
        return 0;
    }

    @Override
    public void setZasieg_ataku() {

    }

    @Override
    public String getNazwa() {
        return null;
    }

    @Override
    public void setNazwa() {

    }

    @Override
    public int getAtak() {
        return 0;
    }

    @Override
    public void setAtak() {

    }

    @Override
    public int getNr_pola() {
        return 0;
    }

    @Override
    public void setNr_pola() {

    }
}
