import java.util.Random;
public class Lucznik extends Jednostka {

   public Lucznik(String name)
    {
        setAtak(80);
        setHp(500);
        setNazwa(name);
        //setNr_pola();
        setPancerz(50);
        setPredkosc_ruchu(100);
        setZasieg_ataku(2);
        setKryt(30);
        setMod_kryt(3);
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
            return true;}return false;
    }
}
