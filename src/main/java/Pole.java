public class Pole implements I_Wspolrzedne {

    private int rozmiar = 1;
    private int nr_pola;

    @Override
    public int getNr_pola() {
        return nr_pola;
    }

    @Override
    public void setNr_pola(int nr_pola) {

        this.nr_pola=nr_pola;

    }
}
