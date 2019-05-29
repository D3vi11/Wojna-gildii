import java.util.Scanner;

public class Gildia {


    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

            for( ;; )
            {
                System.out.println("Wojna-gildii");
                int x = scan.nextInt();
                Mapa mapa = new Mapa(x);

                        if(x==0){
                            System.exit(0);
                        }
            }
    }

    Jednostka [][] tablica_jedn;

    void ustaw_liczbe_gildii() {
    }

    void uruchom_symulacje() {
    }

    void zapisz_wyniki() {
    }

    void ustaw_liczbe_jednostek() {

    }

}