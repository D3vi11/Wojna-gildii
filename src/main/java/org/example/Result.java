package org.example;

import org.example.entities.Archer;
import org.example.entities.Entity;
import org.example.entities.Mage;
import org.example.entities.Warrior;
import org.example.map.Field;
import org.example.map.Ground;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class Result {

    private int warriors;
    private int archers;
    private int mages;


    void count(int entityNumber, Field[][] field, int size) {
        int warriorsAlive = entityNumber;
        int archersAlive = entityNumber;
        int magesAlive = entityNumber;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                for (Entity entity : field[i][j].getEntities()) {
                    if (!entity.getAlive() && entity instanceof Warrior) warriorsAlive--;
                    if (!entity.getAlive() && entity instanceof Archer) archersAlive--;
                    if (!entity.getAlive() && entity instanceof Mage) magesAlive--;
                }

        warriors = warriorsAlive;
        archers = archersAlive;
        mages = magesAlive;
    }

    public void writeOutput(int entityNumber, int warriorsAlive, int archersAlive, int magesAlive, PrintWriter output, Ground ground) {
        int ilosc_martwychW = entityNumber - warriorsAlive;
        int ilosc_martwychL = entityNumber - archersAlive;
        int ilosc_martwychM = entityNumber - magesAlive;
        output.println("Liczba jednostek gildii wojownikow: " + entityNumber);
        output.println("Ilosc zywych jednostek = " + warriorsAlive);
        output.println("Ilosc martwych jednostek = " + ilosc_martwychW);
        output.println("Liczba jednostek gildii łuczników: " + entityNumber);
        output.println("Ilosc zywych jednostek = " + archersAlive);
        output.println("Ilosc martwych jednostek = " + ilosc_martwychL);
        output.println("Liczba jednostek gildii magów: " + entityNumber);
        output.println("Ilosc zywych jednostek = " + magesAlive);
        output.println("Ilosc martwych jednostek = " + ilosc_martwychM);

        for (int i = 0; i < ground.getSize(); i++) {
            for (int j = 0; j < ground.getSize(); j++) {
                for (int k = 0; k < ground.getField(i, j).getEntities().size(); k++) {
                    if (ground.getField(i, j).getUnit(k).getAlive()) {
                        if (ground.getField(i, j).getUnit(k) instanceof Warrior)
                            output.println("Jednostka z gildii wojowników nr " + ground.getField(i, j).getUnit(k).getEntityNumber() + " jest na polu x: " + i + " y: " + j);
                        if (ground.getField(i, j).getUnit(k) instanceof Archer)
                            output.println("Jednostka z gildii luczników nr " + ground.getField(i, j).getUnit(k).getEntityNumber() + " jest na polu x: " + i+ " y: " + j);
                        if (ground.getField(i, j).getUnit(k) instanceof Mage)
                            output.println("Jednostka z gildii Magów nr " + ground.getField(i, j).getUnit(k).getEntityNumber() + " jest na polu x: " + i + " y: " + j);
                    }
                }
            }
        }
    }

    public List<String> victory(int entityNumber, Field[][] field, int size) {

        List<String> list = new ArrayList<>();
        count(entityNumber, field, size);
        if (warriors == 0 && archers == 0) {
            list.add("WYGRALI MAGOWIE");
            return list;
        }
        if (warriors == 0 && mages == 0) {
            list.add("WYGRALI LUCZNICY");
            return list;
        }
        if (archers == 0 && mages == 0) {
            list.add("WYGRALI WOJOWNICY");
            return list;
        }
        list.add("WALKA NIEROZSTRZYGNIĘTA");
        return list;
    }

    int getWarriors() {
        return warriors;
    }

    int getArchers() {
        return archers;
    }

    int getMages() {
        return mages;
    }
}
