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
    public boolean czy_spotkanie() {
        return false;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp=hp;
    }

    @Override
    public int getPredkosc_ruchu() {
        return predkosc_ruchu;
    }

    @Override
    public void setPredkosc_ruchu(int predkosc_ruchu) {
        this.predkosc_ruchu=predkosc_ruchu;
    }

    @Override
    public int getPancerz() {
        return pancerz;
    }

    @Override
    public void setPancerz(int pancerz) {
        this.pancerz=pancerz;
    }

    @Override
    public int getZasieg_ataku() {
        return zasieg_ataku;
    }

    @Override
    public void setZasieg_ataku(int zasieg_ataku) {
        this.zasieg_ataku=zasieg_ataku;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }

    @Override
    public void setNazwa(String nazwa) {
        this.nazwa=nazwa;
    }

    @Override
    public int getAtak() {
        return atak;
    }

    @Override
    public void setAtak(int atak) {
        this.atak=atak;
    }

    @Override
    public int getNr_pola() {
        return nr_pola;
    }

    @Override
    public void setNr_pola(int nr_pola) {
        this.nr_pola=nr_pola;
    }
    public abstract void kryt();


}
