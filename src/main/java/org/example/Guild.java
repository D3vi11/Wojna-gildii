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

public class Guild {

    static BoolString inscription = new BoolString();
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
     * @param entityNumber liczba jednostek od której zacznie się symulacja
     * @param iterationNumber maksymalna liczba iteracji która zakończy symulację w razie nie spełnienia warunku końca
     * @param mapSize rozmiar utworzonej mapy
     * @throws FileNotFoundException wymagane do działania zapisu do pliku
     */
        Guild(int entityNumber, int iterationNumber, int mapSize) throws FileNotFoundException
        {
            Map map = new Map(mapSize); //tworzenie mapy
            int x,y;
            for(int i=0;i<entityNumber;i++)
            {
                x= randomize(mapSize);
                y= randomize(mapSize);
                map.getFieldByXY(x,y).addUnit(new Warrior(i+1));
                x= randomize(mapSize);
                y= randomize(mapSize);
                map.getFieldByXY(x,y).addUnit(new Archer(i+1));
                x= randomize(mapSize);
                y= randomize(mapSize);
                map.getFieldByXY(x,y).addUnit(new Mage(i+1));
            }
            Result result = new Result();
            PrintWriter output = new PrintWriter("Wyniki.txt");
            int iter=0;
            for(int i=0;i<iterationNumber;i++) {
                for (int j = 0; j < mapSize; j++) {
                    for (int k = 0; k < mapSize; k++) {
                        if (map.getField(j, k).checkInstance()) {
                            iter++;
                        } else {
                            iter = 0;
                        }
                        if (iter == entityNumber) {
                            map.move(mapSize);
                          }
                    }
                }




              for(int j=0;j < mapSize;j++)
                    for(int k=0;k<mapSize;k++)
                    for(int g = 0; g< map.getField(j,k).get_list().size(); g++)
                        for(int z = 0; z< map.getField(j,k).get_list().size(); z++)
                    { map.getField(j,k).getUnit(g).attack(map.getField(j,k).getUnit(z));
                    }
                result.count(entityNumber, map.getFieldTable(),mapSize);
                output.println(" ");
                output.println("ITERACJA NR "+ (i+1));
                output.println(" ");
                result.writeOutput(entityNumber, result.getWarriors(), result.getArchers(), result.getMages(), output, map);
                if(result.victory(entityNumber, inscription, map.getFieldTable(),mapSize).getX())break;
            }

            output.close();
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
     * @param mapSize rozmiar mapy
     * @return liczba z zakresu od 1 do rozmiaru mapy
     */
    private static int randomize(int mapSize)
        {
            Random random = new Random();
            return random.nextInt(mapSize)+1;
        }

    public static BoolString getInscription(){
        return inscription;
    }
    }

