public interface I_Jednostka {
    void ruch();
    void atak();
    boolean czy_spotkanie();
    int getHp();
    void setHp(int hp);
    int getPredkosc_ruchu();
    void setPredkosc_ruchu(int predkosc_ruchu);
    int getPancerz();
    void setPancerz(int pancerz);
    int getZasieg_ataku();
    void setZasieg_ataku(int zasieg_ataku);
    String getNazwa();
    void setNazwa(String nazwa);
    int getAtak();
    void setAtak(int atak);

}
