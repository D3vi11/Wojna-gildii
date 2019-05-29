import java.util.Random;
import java.util.Scanner;

public class Gildia {


    public static void main(String[] args) {


        for ( ; ; ) {
            System.out.println("Wojna-gildii");
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



        private static void uruchom_symulacje (int liczba_jednostek, int liczba_iteracji, int rozmiar_mapy)
        {
            Mapa mapa= new Mapa(rozmiar_mapy);
            Wojownik [] woj_tab = new Wojownik [liczba_jednostek];
            Lucznik [] luk_tab = new Lucznik[liczba_jednostek];
            Mag [] mag_tab = new Mag [liczba_jednostek];
            Random random = new Random();
            for(int i=0;i<liczba_jednostek;i++)
            {
                woj_tab[i]= new Wojownik("wojownik"+(i+1),random.nextInt(rozmiar_mapy),random.nextInt(rozmiar_mapy),i+1);
                luk_tab[i]= new Lucznik("lucznik"+(i+1),random.nextInt(rozmiar_mapy),random.nextInt(rozmiar_mapy),i+1);
                mag_tab[i]= new Mag("mag"+(i+1),random.nextInt(rozmiar_mapy),random.nextInt(rozmiar_mapy),i+1);
            }
            for(int i=0;i<liczba_iteracji;i++)
            {

            }
        }

        public void zapisz_wyniki () {
        }

        private static int  ustaw_liczbe_jednostek () {
            int x = 0;
            while (x < 1 || x > 10) {
                System.out.println("ustaw liczbe jednostek(od 1 do 10)");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
            }
            return x;
        }
        private static int ustaw_liczbe_iteracji(){
            int x = 0;
            while (x < 1) {
                System.out.println("ustaw maksymalna liczbe iteracji");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
            }
            return x;

        }
        private static int ustaw_rozmiar_mapy()
        {
            int x = 0;
            while (x < 1) {
                System.out.println("ustaw rozmiar mapy");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
            }
            return x;

        }

    }
