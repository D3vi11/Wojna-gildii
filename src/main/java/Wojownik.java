import java.util.Random;

public class Wojownik extends Jednostka {


    Wojownik(int wsp_x,int wsp_y, int nr_jednostki)
    {
        super(wsp_x,wsp_y, nr_jednostki);
        setAtak(65);
        setHp(1000);
        setPancerz(70);
        setKryt(35);
        setMod_kryt(2);
        setCzy_zywy(true);
    }

    @Override
    public void atak(Jednostka wrog) {
        if (losuj_kryt())
            kryt(wrog,getMod_kryt());
        else
        wrog.setHp((wrog.getHp()-getAtak())+wrog.getPancerz()/10);
        wrog.smierc(wrog.getHp());

    }

    @Override
    public void kryt(Jednostka wrog,int mod_kryt) {
            wrog.setHp((wrog.getHp()-mod_kryt*getAtak())+wrog.getPancerz()/10);
    }

    @Override
    public boolean losuj_kryt() {
        Random generator=new Random();
        int x = generator.nextInt(100);
        if(x>=0&&x<getKryt())
        return true;
        else return false;
    }
}
