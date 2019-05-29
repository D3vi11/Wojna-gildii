public interface I_Jednostka {
    void ruch(int rozmiar);
    void atak(Jednostka wrog);
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
    int getKryt();
    void setKryt(int kryt);
    int getMod_kryt();
    void setMod_kryt(int mod_kryt);
    int getNr_gildii();
    void setNr_gildii(int nr_gildii);
    public boolean getCzy_żywy();
    public void setCzy_żywy(boolean czy_żywy);

}
