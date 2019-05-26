public class Mapa implements I_Mapa {

    private int rozmiar;
    private Pole [] tablica_pol;

    @Override
    public boolean jesli_poza_mapa() {
        return false;
    }

    @Override
    public int getRozmiar() {
        return rozmiar;
    }

    @Override
    public void setRozmiar(int rozmiar) {
        this.rozmiar=rozmiar;
    }
}
