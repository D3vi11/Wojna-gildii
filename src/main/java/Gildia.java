import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Gildia {


    public static void main(String[] args) throws FileNotFoundException {


        for ( ; ; ) {
            System.out.println("Wojna-gildii:");
            int liczba_jednostek=ustaw_liczbe_jednostek();
            int max_liczba_iteracji=ustaw_liczbe_iteracji();
            int rozmiar_mapy=ustaw_rozmiar_mapy();
            uruchom_symulacje(liczba_jednostek,max_liczba_iteracji,rozmiar_mapy);

            System.out.println("Czy chcesz powtorzyc symulacje?");
            System.out.println("1-TAK");
            System.out.println("0-NIE");
            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            if(x==0){System.exit(0);}
        }

    }



        private static void uruchom_symulacje (int liczba_jednostek, int liczba_iteracji, int rozmiar_mapy) throws FileNotFoundException // SYMULACJA
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
                woj_tab[i]= new Wojownik("wojownik"+(i+1),x,y,i+1);
                x=losuj(rozmiar_mapy);
                y=losuj(rozmiar_mapy);
                luk_tab[i]= new Lucznik("lucznik"+(i+1),x,y,i+1);
                x=losuj(rozmiar_mapy);
                y=losuj(rozmiar_mapy);
                mag_tab[i]= new Mag("mag"+(i+1),x,y,i+1);
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
                if(zwyciestwo(liczba_jednostek,woj_tab,luk_tab,mag_tab))break;
            }

            wynik.zlicz_wojownik(liczba_jednostek,woj_tab);
            wynik.zlicz_lucznik(liczba_jednostek,luk_tab);
            wynik.zlicz_mag(liczba_jednostek,mag_tab);
            wynik.wypiszW(liczba_jednostek,wynik.getWojownicy());
            wynik.wypiszL(liczba_jednostek,wynik.getLucznicy());
            wynik.wypiszM(liczba_jednostek,wynik.getMagowie());
            wynik.jednostki_wojownik(liczba_jednostek,woj_tab);
            wynik.jednostki_lucznik(liczba_jednostek,luk_tab);
            wynik.jednostki_mag(liczba_jednostek,mag_tab);
            wyniki.close();
        }



        private static boolean zwyciestwo(int liczba_jednostek, Wojownik[] woj_tab, Lucznik[] luk_tab, Mag[] mag_tab){

        Wynik jednostki = new Wynik();
            jednostki.zlicz_wojownik(liczba_jednostek,woj_tab);
            jednostki.zlicz_lucznik(liczba_jednostek,luk_tab);
            jednostki.zlicz_mag(liczba_jednostek,mag_tab);
        if(jednostki.getWojownicy()==0&&jednostki.getLucznicy()==0) {
            System.out.println("WYGRALI MAGOWIE" );
            return true;
        }
        if(jednostki.getWojownicy()==0&&jednostki.getMagowie()==0)
        {
            System.out.println("WYGRALI LUCZNICY");
            return true;
        }
        if(jednostki.getLucznicy()==0&&jednostki.getMagowie()==0)
        {
            System.out.println("WYGRALI WOJOWNICY");
            return true;
        }
            return false;
        }

        private static int  ustaw_liczbe_jednostek () {
            int x = 0;
            while (x < 1 || x > 1000000) {
                System.out.println("ustaw liczbe jednostek(od 1 do 1000000):");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
            }
            return x;
        }
        private static int ustaw_liczbe_iteracji(){
            int x = 0;
            while (x < 1) {
                System.out.println("ustaw maksymalna liczbe iteracji:");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
            }
            return x;

        }
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
        private static int losuj(int rozmiar_mapy)
        {
            Random random = new Random();
            int x=random.nextInt(rozmiar_mapy+1);
            if(x==0)x++;
            return x;
        }
    }