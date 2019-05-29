import java.util.Random;

public abstract class Jednostka implements I_Wspolrzedne,I_Jednostka {

    private int hp; // ilosc pkt życia
    private int predkosc_ruchu; // wartosc predkosci ruchu
    private int pancerz;  // ilosc pancerza 1 pancerza redukuje podstawowe obrażenia o 0,1%
    private int zasieg_ataku; // zasieg ataku
    private String nazwa; //nazwa
    private int wsp_x, wsp_y; // współrzędnę x i y
    private int kryt; // szanse na trafienie krytyczne %
    private int mod_kryt; // modyfikator trafienia krytycznego (x1,5;x2;x2,5)
    private int atak; // bazowa wartość ataku




    @Override
    public void ruch() {
        Random generator = new Random();
        int r=generator.nextInt(4);
        switch(r)
        {
            case 0: wsp_x++;
            case 1: wsp_x--;
            case 2: wsp_y++;
            case 3: wsp_y--;
        }
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
    public int getKryt() {
        return kryt;
    }

    @Override
    public void setKryt(int kryt) {
        this.kryt=kryt;
    }

    @Override
    public int getMod_kryt() {
        return mod_kryt;
    }

    @Override
    public void setMod_kryt(int mod_kryt) {
        this.mod_kryt=mod_kryt;
    }

    @Override
    public int getWsp_x() {
        return wsp_x;
    }

    @Override
    public void setWsp_x(int wsp_x) {
        this.wsp_x=wsp_x;
    }
    @Override
    public int getWsp_y() {
        return wsp_y;
    }

    @Override
    public void setWsp_y(int wsp_y) {
        this.wsp_y=wsp_y;
    }
    public abstract boolean kryt(Jednostka wrog, int mod_kryt);


}