import java.util.Random;

public class Mag extends Jednostka {

    Mag(String name, int wsp_x, int wsp_y, int nr_jednostki)
    {
        super(wsp_x,wsp_y, nr_jednostki);
        setNr_gildii(3);
        setAtak(80);
        setHp(700);
        setNazwa(name);
        setPancerz(40);
        mana=200;
        obr_many=30;
        setKryt(25);
        setMod_kryt(2);
        setCzy_zywy(true);
    }

    private int mana;
    private int obr_many;



    @Override
    public void atak(Jednostka wrog) {
        if (losuj_kryt()) {
            kryt(wrog,getMod_kryt());
        } else {
            if (mana == 0) {
                wrog.setHp((wrog.getHp() - getAtak()) + wrog.getPancerz() / 10);
            } else {
                wrog.setHp(wrog.getHp() - (getAtak() + obr_many) + getPancerz() / 10);
                mana -= 10;
            }

        }
        wrog.smierc(wrog.getHp());
    }
    @Override
    public void kryt(Jednostka wrog,int mod_kryt) {
            if (mana == 0) {
                wrog.setHp((wrog.getHp() - mod_kryt * getAtak() + wrog.getPancerz() / 10));
            } else {
                wrog.setHp(wrog.getHp() - (mod_kryt * getAtak() + obr_many) + getPancerz() / 10);
                mana -= 10;
            }
    }
    @Override
    public boolean losuj_kryt() {
        Random generator=new Random();
        int x = generator.nextInt(100);
        if(x>=0&&x<getKryt()) {
            return true;
        }
        else return false;
    }

}
