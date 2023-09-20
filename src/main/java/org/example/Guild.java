package org.example;

import org.example.entities.Archer;
import org.example.entities.Mage;
import org.example.entities.Warrior;
import org.example.map.Map;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Guild {

    static BoolString inscription = new BoolString();
    public static MyFrame frame;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new MyFrame();
            }
        });


    }

    Guild(int entityNumber, int iterationNumber, int mapSize) throws FileNotFoundException {
        Map map = new Map(mapSize); //tworzenie mapy
        int x, y;
        for (int i = 0; i < entityNumber; i++) {
            x = randomize(mapSize);
            y = randomize(mapSize);
            map.getFieldByXY(x, y).addUnit(new Warrior(i + 1));
            x = randomize(mapSize);
            y = randomize(mapSize);
            map.getFieldByXY(x, y).addUnit(new Archer(i + 1));
            x = randomize(mapSize);
            y = randomize(mapSize);
            map.getFieldByXY(x, y).addUnit(new Mage(i + 1));
        }
        Result result = new Result();
        PrintWriter output = new PrintWriter("Wyniki.txt");
        int iter = 0;
        for (int i = 0; i < iterationNumber; i++) {
            for (int j = 0; j < mapSize; j++) {
                for (int k = 0; k < mapSize; k++) {
                    if (map.getField(j, k).checkInstance()) {
                        iter++;
                    } else {
                        iter = 0;
                    }
                    if (iter == entityNumber) {
                        map.move(mapSize);
                    }
                }
            }


            for (int j = 0; j < mapSize; j++)
                for (int k = 0; k < mapSize; k++)
                    for (int g = 0; g < map.getField(j, k).get_list().size(); g++)
                        for (int z = 0; z < map.getField(j, k).get_list().size(); z++) {
                            map.getField(j, k).getUnit(g).attack(map.getField(j, k).getUnit(z));
                        }
            result.count(entityNumber, map.getFieldTable(), mapSize);
            output.println(" ");
            output.println("ITERACJA NR " + (i + 1));
            output.println(" ");
            result.writeOutput(entityNumber, result.getWarriors(), result.getArchers(), result.getMages(), output, map);
            if (result.victory(entityNumber, inscription, map.getFieldTable(), mapSize).getX()) break;
        }

        output.close();
    }

    private static int randomize(int mapSize) {
        Random random = new Random();
        return random.nextInt(mapSize) + 1;
    }

    public static BoolString getInscription() {
        return inscription;
    }
}

