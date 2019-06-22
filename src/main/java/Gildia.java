import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


/**
 * \class Gildia
 *  Klasa Gildia
 *
 *  klasa w której odbywa się symulacja.
 *
 */

public class Gildia {

    static BoolString napis= new BoolString();

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
                new MyFrame();
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
            Wojownik [] woj_tab = new Wojownik [liczba_jednostek]; //tworzenie tablic jednostek
            Lucznik [] luk_tab = new Lucznik[liczba_jednostek];
            Mag [] mag_tab = new Mag [liczba_jednostek];

            int x,y;
            for(int i=0;i<liczba_jednostek;i++)
            {
                x=losuj(rozmiar_mapy);
                y=losuj(rozmiar_mapy);
                woj_tab[i]= new Wojownik(x,y,i+1);
                x=losuj(rozmiar_mapy);
                y=losuj(rozmiar_mapy);
                luk_tab[i]= new Lucznik(x,y,i+1);
                x=losuj(rozmiar_mapy);
                y=losuj(rozmiar_mapy);
                mag_tab[i]= new Mag(x,y,i+1);
            }
            Wynik wynik= new Wynik();
            PrintWriter wyniki = new PrintWriter("Wyniki.txt");
            int iter=0;
            for(int i=0;i<liczba_iteracji;i++)
            {
                for(int j=0;j<liczba_jednostek;j++){
                    for(int k=0;k<liczba_jednostek;k++) {

                        if ((woj_tab[j].getWsp_x() == luk_tab[k].getWsp_x() && woj_tab[j].getWsp_y() == luk_tab[k].getWsp_y() && luk_tab[k].getCzy_zywy())
                                || (woj_tab[j].getWsp_x() == mag_tab[k].getWsp_x() && woj_tab[j].getWsp_y() == mag_tab[k].getWsp_y() && mag_tab[k].getCzy_zywy())) { iter=0; break; }
                        else { iter++;

                        }
                    }
                        if (iter==liczba_jednostek) {
                            woj_tab[j].ruch(rozmiar_mapy);
                            iter=0;
                        }
            }
                for(int j=0;j<liczba_jednostek;j++) {
                    for (int k = 0; k < liczba_jednostek; k++) {

                        if ((luk_tab[j].getWsp_x() == woj_tab[k].getWsp_x() && luk_tab[j].getWsp_y() == woj_tab[k].getWsp_y() && woj_tab[k].getCzy_zywy())
                                || (luk_tab[j].getWsp_x() == mag_tab[k].getWsp_x() && luk_tab[j].getWsp_y() == mag_tab[k].getWsp_y() && mag_tab[k].getCzy_zywy())) { iter=0;
                            break;
                        } else {
                            iter++;
                        }

                    }
                         if (iter==liczba_jednostek) {
                               luk_tab[j].ruch(rozmiar_mapy);
                                iter=0;
                         }
                }
                for(int j=0;j<liczba_jednostek;j++) {
                    for (int k = 0; k < liczba_jednostek; k++) {

                        if ((mag_tab[j].getWsp_x() == luk_tab[k].getWsp_x() && mag_tab[j].getWsp_y() == luk_tab[k].getWsp_y() && luk_tab[k].getCzy_zywy())
                                || (mag_tab[j].getWsp_x() == woj_tab[k].getWsp_x() && mag_tab[j].getWsp_y() == woj_tab[k].getWsp_y() & woj_tab[k].getCzy_zywy())) { iter=0;
                            break;
                        } else {
                            iter++;
                        }
                    }
                    if (iter==liczba_jednostek) {
                        mag_tab[j].ruch(rozmiar_mapy);
                        iter=0;
                    }
                }

               for(int k=0;k<liczba_jednostek;k++)
                    for(int j=0;j<liczba_jednostek;j++)
                     {
                         if (woj_tab[j].getWsp_x()==luk_tab[k].getWsp_x()&&woj_tab[j].getWsp_y()==luk_tab[k].getWsp_y())
                         {
                              if(woj_tab[j].getCzy_zywy()&&luk_tab[k].getCzy_zywy()) {woj_tab[j].atak(luk_tab[k]);luk_tab[k].atak(woj_tab[j]);}

                         }
                         if (woj_tab[k].getWsp_x()==luk_tab[j].getWsp_x()&&woj_tab[k].getWsp_y()==luk_tab[j].getWsp_y())
                         {
                             if(luk_tab[j].getCzy_zywy()&&woj_tab[k].getCzy_zywy()){woj_tab[k].atak(luk_tab[j]);luk_tab[j].atak(woj_tab[k]);}
                         }
                         if (mag_tab[j].getWsp_x()==luk_tab[k].getWsp_x()&&mag_tab[j].getWsp_y()==luk_tab[k].getWsp_y())
                         {
                               if(mag_tab[j].getCzy_zywy()&&luk_tab[k].getCzy_zywy()) {mag_tab[j].atak(luk_tab[k]);luk_tab[k].atak(mag_tab[j]);}

                         }
                         if (mag_tab[k].getWsp_x()==luk_tab[j].getWsp_x()&&mag_tab[k].getWsp_y()==luk_tab[j].getWsp_y())
                         {
                             if(mag_tab[k].getCzy_zywy()&&luk_tab[j].getCzy_zywy()){mag_tab[k].atak(luk_tab[j]);luk_tab[j].atak(mag_tab[k]);}
                         }
                         if (mag_tab[j].getWsp_x()==woj_tab[k].getWsp_x()&&mag_tab[j].getWsp_y()==woj_tab[k].getWsp_y())
                         {
                            if(mag_tab[j].getCzy_zywy()&&woj_tab[k].getCzy_zywy()) {woj_tab[k].atak(mag_tab[j]);mag_tab[j].atak(woj_tab[k]);}

                         }
                         if (mag_tab[k].getWsp_x()==woj_tab[j].getWsp_x()&&mag_tab[k].getWsp_y()==woj_tab[j].getWsp_y())
                         {
                             if(mag_tab[k].getCzy_zywy()&&woj_tab[j].getCzy_zywy()){woj_tab[j].atak(mag_tab[k]);mag_tab[k].atak(woj_tab[j]);}
                         }
                     }
                wynik.zlicz_wojownik(liczba_jednostek,woj_tab);
                wynik.zlicz_lucznik(liczba_jednostek,luk_tab);
                wynik.zlicz_mag(liczba_jednostek,mag_tab);
                wyniki.println(" ");
                wyniki.println("ITERACJA NR "+ (i+1));
                wyniki.println(" ");
                wynik.zapisz_wyniki_W(liczba_jednostek,wynik.getWojownicy(),wyniki,woj_tab);
                wynik.zapisz_wyniki_L(liczba_jednostek,wynik.getLucznicy(),wyniki,luk_tab);
                wynik.zapisz_wyniki_M(liczba_jednostek,wynik.getMagowie(),wyniki,mag_tab);
                if(zwyciestwo(liczba_jednostek,woj_tab,luk_tab,mag_tab,napis).getX())break;
            }

         //   wynik.zlicz_wojownik(liczba_jednostek,woj_tab);
          //  wynik.zlicz_lucznik(liczba_jednostek,luk_tab);
          //  wynik.zlicz_mag(liczba_jednostek,mag_tab);
          //  wynik.wypiszW(liczba_jednostek,wynik.getWojownicy());
         //   wynik.wypiszL(liczba_jednostek,wynik.getLucznicy());
         //   wynik.wypiszM(liczba_jednostek,wynik.getMagowie());
         //   wynik.jednostki_wojownik(liczba_jednostek,woj_tab);
          //  wynik.jednostki_lucznik(liczba_jednostek,luk_tab);
          //  wynik.jednostki_mag(liczba_jednostek,mag_tab);

            wyniki.close();
        }


    /**
     * metoda zwycięstwo
     *
     * metoda sprawdza liczbę żywych jednostek i w momencie gdy 2 gildie nie mają już żywych jednostek to wygrywa trzecia gildia
     * jest to zasygnalizowane komunikatem.
     *
     * @param liczba_jednostek maksymalna liczba jednostek w symulacji
     * @param woj_tab tablica obiektów klasy Wojownik
     * @param luk_tab tablica obiektów klasy Lucznik
     * @param mag_tab tablica obiektów klasy Mag
     * @return zwraca true gdy wygra jakakolwiek gildia, zwraca false gdy żadna gildia jeszcze nie wygrała
     */
        private static BoolString zwyciestwo(int liczba_jednostek, Wojownik[] woj_tab, Lucznik[] luk_tab, Mag[] mag_tab,BoolString napis){

        Wynik jednostki = new Wynik();
            jednostki.zlicz_wojownik(liczba_jednostek,woj_tab);
            jednostki.zlicz_lucznik(liczba_jednostek,luk_tab);
            jednostki.zlicz_mag(liczba_jednostek,mag_tab);
        if(jednostki.getWojownicy()==0&&jednostki.getLucznicy()==0) {
           napis.setNapis("WYGRALI MAGOWIE");
           napis.setX(true);
            return napis;
        }
        if(jednostki.getWojownicy()==0&&jednostki.getMagowie()==0)
        {
           napis.setNapis("WYGRALI LUCZNICY");
            napis.setX(true);
            return napis;
        }
        if(jednostki.getLucznicy()==0&&jednostki.getMagowie()==0)
        {
            napis.setNapis("WYGRALI WOJOWNICY");
            napis.setX(true);
            return napis;
        }
            napis.setX(false);
            return napis;
        }

    /**
     * metoda ustaw_liczbe_jednostek
     *
     * metoda pobiera z klawiatury liczbę z zakresu od 1 do 1000000 i ją zwraca, w przypadku złej liczby ponawia prośbę o wprowadzenie nowej liczby
     *
     * @return (liczba jednostek) liczba z zakresu od 1 do 1000000
     */
    private static int  ustaw_liczbe_jednostek () {
            int x = 0;
            while (x < 1 || x > 1000000) {
                System.out.println("ustaw liczbe jednostek(od 1 do 1000000):");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
            }
            return x;
        }

    /**
     * metoda ustaw_liczbe_iteracji
     *
     * metoda pobiera z klawiatury liczbę i ją zwraca
     *
     * @return (maksymalna liczba iteracji) liczba większa od 1
     */
    private static int ustaw_liczbe_iteracji(){
            int x = 0;
            while (x < 1) {
                System.out.println("ustaw maksymalna liczbe iteracji:");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
            }
            return x;

        }

    /**
     * metoda ustaw_rozmiar_mapy
     *
     * metoda pobiera z klawiatury liczbę większą od 1 i ją zwraca
     * @return (rozmiar mapy) liczba większa od 1
     */
    private static int ustaw_rozmiar_mapy()
        {
            int x = 0;
            while (x < 1) {
                System.out.println("ustaw rozmiar mapy:");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
            }
            return x;

        }

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
            int x=random.nextInt(rozmiar_mapy+1);
            if(x==0)x++;
            return x;
        }

    public static BoolString getNapis(){
        return napis;
    }
    }

