public class Pole implements I_Wspolrzedne {

    private int rozmiar;
    private int wsp_x ,wsp_y;

    Pole(int wsp_x, int wsp_y)
    {
        rozmiar=1;
        this.wsp_x=wsp_x;
        this.wsp_y=wsp_y;
    }



    @Override
    public int getWsp_x() {
        return wsp_x;
    }

    @Override
    public void setWsp_x(int wsp_x) {

        this.wsp_x=wsp_x;

    }
    @Override
    public int getWsp_y() {
        return wsp_y;
    }

    @Override
    public void setWsp_y(int wsp_y) {

        this.wsp_y=wsp_y;

    }
}
