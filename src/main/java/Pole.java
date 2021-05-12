import java.util.ArrayList;
import java.util.List;

/**
 * \class Pole
 * Klasa pole.
 *
 * Klasa przypisuje wspolrzedne x i y do pola.
 */

public class Pole implements I_Wspolrzedne {

    private final int wsp_x /**< współrzędna x */,wsp_y; /**< współrzędna y */
    List<I_Jednostka> jednostki = new ArrayList<>();

    /**
     * Metoda przypisuje wartsoci wspolrzednej x i y.
     * @param wsp_x parametr przechowujacy wspolrzedna x.
     * @param wsp_y parametr przechowujacy wspolrzedna y.
     */

    Pole(int wsp_x, int wsp_y)
    {
        this.wsp_x=wsp_x;
        this.wsp_y=wsp_y;
    }

    /**
     * Metoda zwraca wspolrzedna x.
     * @return wspolrzedna x.
     */

    @Override
    public int getWsp_x() {
        return wsp_x;
    }

    /**
     * Metoda zwraca wspolrzedna y.
     * @return wspolrzedna y.
     */

    @Override
    public int getWsp_y() {
        return wsp_y;
    }

    public void addUnit(I_Jednostka jednostka){
        jednostki.add(jednostka);
    }

    public I_Jednostka getUnit(int index){
        return jednostki.get(index);
    }

    public void removeUnit(int index){
        jednostki.remove(index);
    }
    // zwraca true jeśli tylko jeden typ jednostki jest na danym polu i false jeśli jest więcej niż 1 typ
    public boolean checkInstance(){
        boolean woj = false,luk = false,m= false;
        for(I_Jednostka jedn:jednostki){
            if(jedn instanceof Wojownik && jedn.getCzy_zywy()){
                woj=true;
            }
            if(jedn instanceof Lucznik && jedn.getCzy_zywy()){
                luk=true;
            }
            if(jedn instanceof Mag && jedn.getCzy_zywy()){
                m=true;
            }
        }
        if( woj && luk || woj && m || luk && m ){
            return false;
        }else return true;
    }

    public List<I_Jednostka> get_list(){
        return jednostki;
    }
}
