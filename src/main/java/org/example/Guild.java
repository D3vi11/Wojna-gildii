package org.example;

import org.example.entities.Archer;
import org.example.entities.Mage;
import org.example.entities.Warrior;
import org.example.map.Ground;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Guild {
    public static MyFrame frame;

    private static List<String> inscription;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new MyFrame();
            }
        });


    }

    Guild(int entityNumber, int iterationNumber, int mapSize) throws FileNotFoundException {
        Ground ground = new Ground(mapSize);
        int x, y;
        for (int i = 0; i < entityNumber; i++) {
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getField(x, y).addUnit(new Warrior(i + 1));
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getField(x, y).addUnit(new Archer(i + 1));
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getField(x, y).addUnit(new Mage(i + 1));
        }
        Result result = new Result();
        PrintWriter output = new PrintWriter("Wyniki.txt");
        int iter = 0;
        for (int i = 0; i < iterationNumber; i++) {
            for (int j = 0; j < mapSize; j++) {
                for (int k = 0; k < mapSize; k++) {
                    if (ground.getField(j, k).checkIfShouldFight()) {
                        iter++;
                    } else {
                        iter = 0;
                    }
                    if (iter == entityNumber) {
                        ground.move(mapSize);
                    }
                }
            }


            for (int j = 0; j < mapSize; j++)
                for (int k = 0; k < mapSize; k++)
                    for (int g = 0; g < ground.getField(j, k).getEntities().size(); g++)
                        for (int z = 0; z < ground.getField(j, k).getEntities().size(); z++) {
                            ground.getField(j, k).getUnit(g).attack(ground.getField(j, k).getUnit(z));
                        }
            result.count(entityNumber, ground.getFieldTable(), mapSize);
            output.println(" ");
            output.println("ITERACJA NR " + (i + 1));
            output.println(" ");
            result.writeOutput(entityNumber, result.getWarriors(), result.getArchers(), result.getMages(), output, ground);
            inscription = result.victory(entityNumber, ground.getFieldTable(), mapSize);
            if (!inscription.isEmpty()&&!inscription.get(0).equals("WALKA NIEROZSTRZYGNIĘTA")) break;
        }

        output.close();
    }

    private static int randomize(int mapSize) {
        Random random = new Random();
        return random.nextInt(mapSize);
    }

    public static List<String> getInscription() {
        return inscription;
    }
}

