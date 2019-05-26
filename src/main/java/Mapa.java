public class Mapa implements I_Mapa {

    private int rozmiar=5;
    private Pole [] tablica_pol;

    @Override
    public boolean jesli_poza_mapa() {
        return false;
    }

    @Override
    public int getRozmiar() {
        return 0;
    }

    @Override
    public void setRozmiar() {

    }
}
