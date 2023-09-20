package org.example;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * \class Gildia
 *  Klasa Gildia
 *
 *  klasa w której odbywa się symulacja.
 *
 */

public class Gildia {

    static BoolString napis= new BoolString();
    public static MyFrame frame;

    /**
     * metoda main
     *
     *  główna metoda od której zaczyna się symulacja
     * @param args parametr wymagany do działania metody
     */
    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
               frame = new MyFrame();
            }
        });


    }

    /**
     *  metoda uruchom_symulacje
     *
     * metoda tworzy mapę odpowiedniej wielkości oraz tworzy jednostki i rozmieszcza je na mapie, w następnej kolejności symuluje ruch jednostek i w razie ich spotkania atak
     *
     * @param liczba_jednostek liczba jednostek od której zacznie się symulacja
     * @param liczba_iteracji maksymalna liczba iteracji która zakończy symulację w razie nie spełnienia warunku końca
     * @param rozmiar_mapy rozmiar utworzonej mapy
     * @throws FileNotFoundException wymagane do działania zapisu do pliku
     */
        Gildia (int liczba_jednostek, int liczba_iteracji, int rozmiar_mapy) throws FileNotFoundException
        {
            Mapa mapa= new Mapa(rozmiar_mapy); //tworzenie mapy
            int x,y;
            for(int i=0;i<liczba_jednostek;i++)
            {
                x=losuj(rozmiar_mapy);
                y=losuj(rozmiar_mapy);
                mapa.getPoleByXY(x,y).addUnit(new Wojownik(i+1));
                x=losuj(rozmiar_mapy);
                y=losuj(rozmiar_mapy);
                mapa.getPoleByXY(x,y).addUnit(new Lucznik(i+1));
                x=losuj(rozmiar_mapy);
                y=losuj(rozmiar_mapy);
                mapa.getPoleByXY(x,y).addUnit(new Mag(i+1));
            }
            Wynik wynik= new Wynik();
            PrintWriter wyniki = new PrintWriter("Wyniki.txt");
            int iter=0;
            for(int i=0;i<liczba_iteracji;i++) {
                for (int j = 0; j < rozmiar_mapy; j++) {
                    for (int k = 0; k < rozmiar_mapy; k++) {
                        if (mapa.getPole(j, k).checkInstance()) {
                            iter++;
                        } else {
                            iter = 0;
                        }
                        if (iter == liczba_jednostek) {
                            mapa.ruch(rozmiar_mapy);
                          }
                    }
                }




              for(int j=0;j < rozmiar_mapy;j++)
                    for(int k=0;k<rozmiar_mapy;k++)
                    for(int g=0;g<mapa.getPole(j,k).get_list().size();g++)
                        for(int z=0;z<mapa.getPole(j,k).get_list().size();z++)
                    { mapa.getPole(j,k).getUnit(g).atak(mapa.getPole(j,k).getUnit(z));
                    }
                wynik.zlicz(liczba_jednostek,mapa.getTablica_pol(),rozmiar_mapy);
                wyniki.println(" ");
                wyniki.println("ITERACJA NR "+ (i+1));
                wyniki.println(" ");
                wynik.zapisz_wyniki(liczba_jednostek,wynik.getWojownicy(), wynik.getLucznicy(),wynik.getMagowie(), wyniki,mapa);
                if(wynik.zwyciestwo(liczba_jednostek,napis,mapa.getTablica_pol(),rozmiar_mapy).getX())break;
            }

            wyniki.close();
        }


                /**
                 * metoda zwycięstwo
                 *
                 * metoda sprawdza liczbę żywych jednostek i w momencie gdy 2 gildie nie mają już żywych jednostek to wygrywa trzecia gildia
                 * jest to zasygnalizowane komunikatem.
                 *
                 * @param liczba_jednostek maksymalna liczba jednostek w symulacji
                 * @return zwraca true gdy wygra jakakolwiek gildia, zwraca false gdy żadna gildia jeszcze nie wygrała
                 */

    /**
     * metoda losuj
     *
     * metoda losuje liczbe z zakresu od 1 do rozmiaru mapy a następnie ją zwraca
     * @param rozmiar_mapy rozmiar mapy
     * @return liczba z zakresu od 1 do rozmiaru mapy
     */
    private static int losuj(int rozmiar_mapy)
        {
            Random random = new Random();
            return random.nextInt(rozmiar_mapy)+1;
        }

    public static BoolString getNapis(){
        return napis;
    }
    }

