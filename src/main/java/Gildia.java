import java.util.Random;
import java.util.Scanner;

public class Gildia {


    public static void main(String[] args) {


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



        private static void uruchom_symulacje (int liczba_jednostek, int liczba_iteracji, int rozmiar_mapy) // SYMULACJA
        {
            Mapa mapa= new Mapa(rozmiar_mapy);
            Wojownik [] woj_tab = new Wojownik [liczba_jednostek];
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
            for(int i=0;i<liczba_iteracji;i++)
            {
               for(int j=0;j<liczba_jednostek;j++)
               {
                   woj_tab[j].ruch(rozmiar_mapy);
                   luk_tab[j].ruch(rozmiar_mapy);
                   mag_tab[j].ruch(rozmiar_mapy);

               }
               for(int k=0;k<liczba_jednostek;k++)
               for(int j=0;j<liczba_jednostek;j++)
               {
                   if (woj_tab[j].getWsp_x()==luk_tab[k].getWsp_x()&&woj_tab[j].getWsp_y()==luk_tab[k].getWsp_y())
                   {
                      if(woj_tab[j].getCzy_zywy()) woj_tab[j].atak(luk_tab[k]); if(luk_tab[j].getCzy_zywy()) luk_tab[j].atak(woj_tab[k]);
                   }
                   if (mag_tab[j].getWsp_x()==luk_tab[k].getWsp_x()&&mag_tab[j].getWsp_y()==luk_tab[k].getWsp_y())
                   {
                       if(mag_tab[j].getCzy_zywy()) mag_tab[j].atak(luk_tab[k]); if(luk_tab[j].getCzy_zywy()) luk_tab[j].atak(mag_tab[k]);
                   }
                   if (mag_tab[j].getWsp_x()==woj_tab[k].getWsp_x()&&mag_tab[j].getWsp_y()==woj_tab[k].getWsp_y())
                   {
                       if(woj_tab[j].getCzy_zywy()) woj_tab[j].atak(mag_tab[k]); if(mag_tab[j].getCzy_zywy()) mag_tab[j].atak(woj_tab[k]);
                   }
               }

            }
            Wynik wynik= new Wynik();
            wynik.zlicz_wojownik(liczba_jednostek,woj_tab);
            wynik.zlicz_lucznik(liczba_jednostek,luk_tab);
            wynik.zlicz_mag(liczba_jednostek,mag_tab);
            wynik.jednostki_wojownik(liczba_jednostek,woj_tab);
            wynik.jednostki_lucznik(liczba_jednostek,luk_tab);
            wynik.jednostki_mag(liczba_jednostek,mag_tab);
        }

        public void zapisz_wyniki () {


        }

        private static int  ustaw_liczbe_jednostek () {
            int x = 0;
            while (x < 1 || x > 10) {
                System.out.println("ustaw liczbe jednostek(od 1 do 10):");
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
