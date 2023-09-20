package org.example;

import java.util.Random;

/**
 * \class Mapa
 * Klasa tworzy mape.
 *
 * Klasa sluzy do stworzenia mapy zlonej z pol i mjacej dany rozmiar.
 */

public class Map {

    private Field[][] fieldTable; /**< Tablica przechowujaca pola o wspolrzednych x i y. */
    private final int size;

    /**
     * Konstruktor klasy Mapa.
     *
     * Metoda pobiera zadana przez uzytkownika dlugosc boku mapy i na jego bazie tworzy te mape(kwadrat) zlozona z pol.
     *
     * @param size parametr przechowujace rozmiar mapy.
     */

    Map(int size)
    {
        this.size = size;
        fieldTable = new Field[size][size];
        for(int i = 0; i< size; i++)
        for(int j = 0; j< size; j++)
        {
            fieldTable[i][j]= new Field(i+1,j+1);
        }
    }

    public Field[][] getFieldTable(){
        return fieldTable;
    }

    public Field getFieldByXY(int x, int y){
        return fieldTable[x-1][y-1];
    }
    public Field getField(int x, int y){
        return fieldTable[x][y];
    }

    public int gerNumberOfFields(){
        return size ^2;
    }
    public int getSize(){return size;}
    public void move(int size) {
        Random generator = new Random();
        int r;
        for(int i = 0; i < size; i++)
        for(int j = 0; j < size; j++)
        for(int k = 0; k< fieldTable[i][j].get_list().size(); k++){
            r = generator.nextInt(4);
            switch (r) {
                case 0: {
                    if (fieldTable[i][j].getX() < size) {
                        fieldTable[i+1][j].addUnit(fieldTable[i][j].getUnit(k));
                        fieldTable[i][j].removeUnit(k);
                    }
                }
                break;
                case 1: {
                    if (fieldTable[i][j].getX() > 1) {
                        fieldTable[i-1][j].addUnit(fieldTable[i][j].getUnit(k));
                        fieldTable[i][j].removeUnit(k);
                    }
                }
                break;
                case 2: {
                    if (fieldTable[i][j].getY() < size) {
                        fieldTable[i][j+1].addUnit(fieldTable[i][j].getUnit(k));
                        fieldTable[i][j].removeUnit(k);
                    }
                }
                break;
                case 3: {
                    if (fieldTable[i][j].getY() > 1) {
                        fieldTable[i][j-1].addUnit(fieldTable[i][j].getUnit(k));
                        fieldTable[i][j].removeUnit(k);
                    }
                }
                break;
            }
        }
    }
}