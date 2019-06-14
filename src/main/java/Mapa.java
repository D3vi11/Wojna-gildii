/**
 * \class Mapa
 * Klasa tworzy mape.
 *
 * Klasa sluzy do stworzenia mapy zlonej z pol i mjacej dany rozmiar.
 */

public class Mapa {

    private int rozmiar; /**< Zmienne przechowujace dlugosc boku mapy */
    private Pole [][] tablica_pol; /**< Tablica przechowujaca pola o wspolrzednych x i y. */

    /**
     * Konstruktor klasy Mapa.
     *
     * Metoda pobiera zadana przez uzytkownika dlugosc boku mapy i na jego bazie tworzy te mape(kwadrat) zlozona z pol.
     *
     * @param rozmiar parametr przechowujace rozmiar mapy.
     */

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

}
