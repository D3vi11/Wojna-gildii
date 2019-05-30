import java.util.Random;

public abstract class Jednostka implements I_Wspolrzedne,I_Jednostka {

    private int hp; // ilosc pkt życia
    private int predkosc_ruchu; // wartosc predkosci ruchu
    private int pancerz;  // ilosc pancerza 1 pancerza redukuje podstawowe obrażenia o 0,1%
    private int zasieg_ataku; // zasieg ataku
    private String nazwa; //nazwa
    private int wsp_x, wsp_y; // współrzędnę x i y
    private int kryt; // szanse na trafienie krytyczne % (nie wpływa na dodatkowe obrażenia maga)
    private int mod_kryt; // modyfikator trafienia krytycznego (x2,x3)
    private int atak; // bazowa wartość ataku
    private int nr_gildii;// numer gildii
    private int nr_jednostki; // numer jednostki
    private boolean czy_zywy; //flaga życia


    @Override
    public int getNr_jednostki() {
        return nr_jednostki;
    }

    @Override
    public void setNr_jednostki(int nr_jednostki) {
        this.nr_jednostki = nr_jednostki;
    }


    public boolean getCzy_zywy() {
        return czy_zywy;
    }

    public void setCzy_zywy(boolean czy_zywy) {
        this.czy_zywy = czy_zywy;
    }



    public int getNr_gildii() {
        return nr_gildii;
    }

    public void setNr_gildii(int nr_gildii) {
        this.nr_gildii = nr_gildii;
    }

    Jednostka(int wsp_x, int wsp_y, int nr_jednostki)
    {
        this.nr_jednostki=nr_jednostki;
        this.wsp_x=wsp_x;
        this.wsp_y=wsp_y;
    }


    @Override
    public void ruch(int rozmiar) {
        Random generator = new Random();
        int r;
            r = generator.nextInt(4);
            switch (r) {
                case 0: {if (wsp_x!=rozmiar)
                    wsp_x++;
                }
                case 1:{ if (wsp_x!=1)
                    wsp_x--;}
                case 2: {if (wsp_y!=rozmiar)
                    wsp_y++;}
                case 3: {if (wsp_y!=1)
                    wsp_y--;}
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
    public abstract void kryt(Jednostka wrog, int mod_kryt);
    void smierc(int hp)
    {
        if(hp<=0) czy_zywy=false;
        else czy_zywy=true;
    }


}
