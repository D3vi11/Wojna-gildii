import java.util.Scanner;

public class Gildia {


    public static void main(String[] args) {


        for ( ; ; ) {
            System.out.println("Wojna-gildii");
            int liczba_jednostek=ustaw_liczbe_jednostek();
            int max_liczba_iteracji;


            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            if(x==0){
                 System.exit(0);
            }
        }

    }
        Jednostka[][] tablica_jedn;


        public void uruchom_symulacje () {

            //Mapa mapa = new Mapa(x);
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

    }
