import java.util.Random;
public class Lucznik extends Jednostka {

    Lucznik(String name, int wsp_x, int wsp_y, int nr_jednostki)
    {
        super(wsp_x,wsp_y,nr_jednostki);
        setNr_gildii(2);
        setAtak(80);
        setHp(500);
        setNazwa(name);
        //setNr_pola();
        setPancerz(50);
        setPredkosc_ruchu(100);
        setZasieg_ataku(2);
        setKryt(30);
        setMod_kryt(3);
        setCzy_zywy(true);
    }

    @Override
    public void atak(Jednostka wrog) {
      //  if (losuj_kryt()) {
      //      kryt(wrog,getMod_kryt());
     //   } else
        wrog.setHp((wrog.getHp()-getAtak())+wrog.getPancerz()/10);
        wrog.smierc(wrog.getHp());

    }

    @Override
    public void kryt(Jednostka wrog,int mod_kryt) {
        wrog.setHp((wrog.getHp() - mod_kryt * getAtak()) + wrog.getPancerz() / 10);
        if (wrog.getAtak() >= 10) wrog.setAtak(wrog.getAtak() - 5);
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

