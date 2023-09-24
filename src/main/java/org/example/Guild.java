package org.example;

import lombok.Getter;
import org.example.entities.Archer;
import org.example.entities.Mage;
import org.example.entities.Warrior;
import org.example.map.Ground;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

@Getter
public class Guild {
    public static MyFrame frame;

    private static List<String> inscription;

    public static void main(String[] args) {
        EventQueue.invokeLater(()-> frame = new MyFrame());
    }

    Guild(int entityNumber, int iterationNumber, int mapSize) throws FileNotFoundException {

        //create map
        Ground ground = new Ground(mapSize);
        int x, y;

        //fill map with entities
        for (int i = 0; i < entityNumber; i++) {
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getFieldMap().get(x+"|"+y).add(new Warrior(i + 1));
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getFieldMap().get(x+"|"+y).add(new Archer(i + 1));
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getFieldMap().get(x+"|"+y).add(new Mage(i + 1));
        }

        //initialize file
        Result result = new Result();
        PrintWriter output = new PrintWriter("Wyniki.txt");

        //move entities
        for (int i = 0; i < iterationNumber; i++) {
            ground.moveEntities();

            //attack
            for (int j = 0; j < mapSize; j++)
                for (int k = 0; k < mapSize; k++)
                    for (int g = 0; g < ground.getFieldMap().get(j+"|"+k).size(); g++)
                        for (int z = 0; z < ground.getFieldMap().get(j+"|"+k).size(); z++) {
                            ground.getFieldMap().get(j+"|"+k).get(g).attack(ground.getFieldMap().get(j+"|"+k).get(z));
                        }
            //write to file
            result.count(entityNumber, ground.getFieldMap(), mapSize);
            output.println(" ");
            output.println("ITERACJA NR " + (i + 1));
            output.println(" ");
            result.writeOutput(entityNumber, result.getWarriors(), result.getArchers(), result.getMages(), output, ground);
            inscription = result.victory(entityNumber, ground.getFieldMap(), mapSize);
            if (!inscription.isEmpty() && !inscription.get(0).equals("WALKA NIEROZSTRZYGNIĘTA")) break;
        }

        //close file
        output.close();
    }

    private static int randomize(int mapSize) {
        Random random = new Random();
        return random.nextInt(mapSize);
    }
}

