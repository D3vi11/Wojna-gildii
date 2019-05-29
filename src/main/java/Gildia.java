import java.util.Scanner;

public class Gildia {


    public static void main(String[] args) {


        for ( ; ; ) {
            System.out.println("Wojna-gildii");
            int liczba_gildii = ustaw_liczbe_gildii();
            int liczba_jednostek;
            int max_liczba_iteracji;


            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            if(x==0){
                 System.exit(0);
            }
        }

    }
        Jednostka[][] tablica_jedn;

        private static int ustaw_liczbe_gildii () {
            int x = 0;
            while (x < 2 || x > 5) {
                System.out.println("Podaj liczbe gildii (od 2 do 5)");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
            }
            return x;
        }

        public void uruchom_symulacje () {

            //Mapa mapa = new Mapa(x);
        }

        public void zapisz_wyniki () {
        }

        public void ustaw_liczbe_jednostek () {

        }

    }
