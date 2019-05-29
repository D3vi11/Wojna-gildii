public class Mapa implements I_Mapa {

    private int rozmiar;
    private Pole [][] tablica_pol;

    Mapa(int rozmiar)
    {
        this.rozmiar=rozmiar;
        tablica_pol= new Pole[rozmiar][rozmiar];
        for(int i=0;i<rozmiar;i++)
        for(int j=0;j<rozmiar;j++)
        {
            tablica_pol[i][j]= new Pole(i+1,j+1);
        }
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
