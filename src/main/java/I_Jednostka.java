public interface I_Jednostka {
    void ruch(int rozmiar);
    void atak(Jednostka wrog);
    int getHp();
    void setHp(int hp);
    int getPancerz();
    void setPancerz(int pancerz);
    void setNazwa(String nazwa);
    int getAtak();
    void setAtak(int atak);
    int getKryt();
    void setKryt(int kryt);
    int getMod_kryt();
    void setMod_kryt(int mod_kryt);
    boolean getCzy_zywy();
    void setCzy_zywy(boolean czy_zywy);
    int getNr_jednostki();
    boolean losuj_kryt();

}
