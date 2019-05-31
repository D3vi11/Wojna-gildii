import java.util.Random;

public class Mag extends Jednostka {

    Mag(String name, int wsp_x, int wsp_y, int nr_jednostki)
    {
        super(wsp_x,wsp_y, nr_jednostki);
        setNr_gildii(3);
        setAtak(70);
        setHp(500);
        setNazwa(name);
        //setNr_pola();
        setPancerz(20);
        setPredkosc_ruchu(100);
        setZasieg_ataku(2);
        mana=100;
        setKryt(20);
        setMod_kryt(3);
        setCzy_zywy(true);
    }

    private int mana;

    public int getMana()
    {
        return mana;
    }
    public void setMana(int mana)
    {
        this.mana=mana;

    }

    @Override
    public void atak(Jednostka wrog) {
        if (losuj_kryt()) {
            kryt(wrog,getMod_kryt());
        } else {
            if (mana == 0) {
                wrog.setHp((wrog.getHp() - getAtak()) + wrog.getPancerz() / 10);
            } else {
                wrog.setHp(wrog.getHp() - (getAtak() + 10) + getPancerz() / 10);
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
                wrog.setHp(wrog.getHp() - (mod_kryt * getAtak() + 10) + getPancerz() / 10);
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
