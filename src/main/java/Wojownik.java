import java.util.Random;

public class Wojownik extends Jednostka {


    public Wojownik(String name)
    {
        setAtak(100);
        setHp(1000);
        setNazwa(name);
        //setNr_pola();
        setPancerz(100);
        setPredkosc_ruchu(100);
        setZasieg_ataku(1);
        setKryt(40);
        setMod_kryt(2);
    }

    @Override
    public void atak(Jednostka wrog) {
        boolean x=kryt(wrog,getMod_kryt());
        if (!x)
        wrog.setHp((wrog.getHp()-getAtak())+wrog.getPancerz()/10);

    }

    @Override
    public boolean kryt(Jednostka wrog,int mod_kryt) {
        Random generator=new Random();
        int x = generator.nextInt(100);
        if(x>=0&&x<=getKryt()){
            wrog.setHp((mod_kryt*(wrog.getHp()-getAtak()))+wrog.getPancerz()/10);
            return true;
        } else
        return false;
    }
}
