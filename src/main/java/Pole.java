/**
 * \brief Klasa pole.
 *
 * Klasa przypisuje wspolrzedne x i y do pola.
 */

public class Pole implements I_Wspolrzedne {

    private int wsp_x /**< współrzędna x */,wsp_y; /**< współrzędna y */

    /**
     * \brief Metoda przypisuje wartsoci wspolrzednej x i y.
     * @param wsp_x parametr przechowujacy wspolrzedna x.
     * @param wsp_y parametr przechowujacy wspolrzedna y.
     */

    Pole(int wsp_x, int wsp_y)
    {
        this.wsp_x=wsp_x;
        this.wsp_y=wsp_y;
    }

    /**
     * \brief Metoda zwraca wspolrzedna x.
     * @return wspolrzedna x.
     */

    @Override
    public int getWsp_x() {
        return wsp_x;
    }

    /**
     * \brief Metoda zwraca wspolrzedna y.
     * @return wspolrzedna y.
     */

    @Override
    public int getWsp_y() {
        return wsp_y;
    }


}
