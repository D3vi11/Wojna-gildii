package org.example;

import org.example.entities.Archer;
import org.example.entities.Entity;
import org.example.entities.Mage;
import org.example.entities.Warrior;
import org.example.map.Field;
import org.example.map.Map;

import java.io.PrintWriter;

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
                for (Entity entity : field[i][j].get_list()) {
                    if (!entity.getAlive() && entity instanceof Warrior) warriorsAlive--;
                    if (!entity.getAlive() && entity instanceof Archer) archersAlive--;
                    if (!entity.getAlive() && entity instanceof Mage) magesAlive--;
                }

        warriors = warriorsAlive;
        archers = archersAlive;
        mages = magesAlive;
    }

    public void writeOutput(int entityNumber, int warriorsAlive, int archersAlive, int magesAlive, PrintWriter output, Map map) {
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

        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                for (int k = 0; k < map.getField(i, j).get_list().size(); k++) {
                    if (map.getField(i, j).getUnit(k).getAlive()) {
                        if (map.getField(i, j).getUnit(k) instanceof Warrior)
                            output.println("Jednostka z gildii wojowników nr " + map.getField(i, j).getUnit(k).getEntityNumber() + " jest na polu x: " + map.getField(i, j).getX() + " y: " + map.getField(i, j).getY());
                        if (map.getField(i, j).getUnit(k) instanceof Archer)
                            output.println("Jednostka z gildii luczników nr " + map.getField(i, j).getUnit(k).getEntityNumber() + " jest na polu x: " + map.getField(i, j).getX() + " y: " + map.getField(i, j).getY());
                        if (map.getField(i, j).getUnit(k) instanceof Mage)
                            output.println("Jednostka z gildii Magów nr " + map.getField(i, j).getUnit(k).getEntityNumber() + " jest na polu x: " + map.getField(i, j).getX() + " y: " + map.getField(i, j).getY());
                    }
                }
            }
        }
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

    public BoolString victory(int entityNumber, BoolString inscription, Field[][] field, int size) {

        count(entityNumber, field, size);
        if (warriors == 0 && archers == 0) {
            inscription.setInscription("WYGRALI MAGOWIE");
            inscription.setX(true);
            return inscription;
        }
        if (warriors == 0 && mages == 0) {
            inscription.setInscription("WYGRALI LUCZNICY");
            inscription.setX(true);
            return inscription;
        }
        if (archers == 0 && mages == 0) {
            inscription.setInscription("WYGRALI WOJOWNICY");
            inscription.setX(true);
            return inscription;
        }
        inscription.setX(false);
        inscription.setInscription("WALKA NIEROZSTRZYGNIĘTA");
        return inscription;
    }
}
