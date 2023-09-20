package org.example;

import java.util.Random;

/**
 * \class Mapa
 * Klasa tworzy mape.
 *
 * Klasa sluzy do stworzenia mapy zlonej z pol i mjacej dany rozmiar.
 */

public class Mapa {

    private Pole[][] tablica_pol; /**< Tablica przechowujaca pola o wspolrzednych x i y. */
    private final int rozmiar;

    /**
     * Konstruktor klasy Mapa.
     *
     * Metoda pobiera zadana przez uzytkownika dlugosc boku mapy i na jego bazie tworzy te mape(kwadrat) zlozona z pol.
     *
     * @param rozmiar parametr przechowujace rozmiar mapy.
     */

    Mapa(int rozmiar)
    {
        this.rozmiar = rozmiar;
        tablica_pol= new Pole[rozmiar][rozmiar];
        for(int i=0;i<rozmiar;i++)
        for(int j=0;j<rozmiar;j++)
        {
            tablica_pol[i][j]= new Pole(i+1,j+1);
        }
    }

    public Pole[][] getTablica_pol(){
        return tablica_pol;
    }

    public Pole getPoleByXY(int x, int y){
        return tablica_pol[x-1][y-1];
    }
    public Pole getPole(int x, int y){
        return tablica_pol[x][y];
    }

    public int gerNumberOfFields(){
        return rozmiar^2;
    }
    public int getRozmiar(){return rozmiar;}
    public void ruch(int rozmiar) {
        Random generator = new Random();
        int r;
        for(int i = 0; i < rozmiar; i++)
        for(int j = 0; j < rozmiar; j++)
        for(int k = 0; k< tablica_pol[i][j].get_list().size();k++){
            r = generator.nextInt(4);
            switch (r) {
                case 0: {
                    if (tablica_pol[i][j].getWsp_x() < rozmiar) {
                        tablica_pol[i+1][j].addUnit(tablica_pol[i][j].getUnit(k));
                        tablica_pol[i][j].removeUnit(k);
                    }
                }
                break;
                case 1: {
                    if (tablica_pol[i][j].getWsp_x() > 1) {
                        tablica_pol[i-1][j].addUnit(tablica_pol[i][j].getUnit(k));
                        tablica_pol[i][j].removeUnit(k);
                    }
                }
                break;
                case 2: {
                    if (tablica_pol[i][j].getWsp_y() < rozmiar) {
                        tablica_pol[i][j+1].addUnit(tablica_pol[i][j].getUnit(k));
                        tablica_pol[i][j].removeUnit(k);
                    }
                }
                break;
                case 3: {
                    if (tablica_pol[i][j].getWsp_y() > 1) {
                        tablica_pol[i][j-1].addUnit(tablica_pol[i][j].getUnit(k));
                        tablica_pol[i][j].removeUnit(k);
                    }
                }
                break;
            }
        }
    }
}
