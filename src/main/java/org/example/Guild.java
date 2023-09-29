package org.example;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.entities.Archer;
import org.example.entities.Entity;
import org.example.entities.Mage;
import org.example.entities.Warrior;
import org.example.map.Ground;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

@RequiredArgsConstructor
public class Guild {
    Ground ground;
    @NonNull
    int entityNumber;
    @NonNull
    int iterationNumber;
    @NonNull
    int mapSize;
    Result result;

    public void run() {
        fillGround();

        try {
            result = new Result(new PrintWriter("Output.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }


        for (int i = 0; i < iterationNumber; i++) {
            moveAndFight();
            result.writeOutput(entityNumber, ground, i);
            if (result.victory()) break;
        }

        result.closeFile();
    }

    private static int randomize(int mapSize) {
        Random random = new Random();
        return random.nextInt(mapSize);
    }

    public void moveAndFight() {
        ground.resetEntitiesMovement();
        for (String key : ground.getFieldMap().keySet()) {
            ground.moveEntities(key);
            ground.attack(key);
        }
    }

    public void fillGround() {
        ground = new Ground(mapSize);
        int x, y;
        for (int i = 0; i < entityNumber; i++) {
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getFieldMap().get(x + "|" + y).add(new Warrior());
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getFieldMap().get(x + "|" + y).add(new Archer());
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getFieldMap().get(x + "|" + y).add(new Mage());
        }
    }

    public void resetStaticData() {
        Result.inscription = null;
        Entity.setArcherCount(0);
        Entity.setWarriorCount(0);
        Entity.setMageCount(0);
    }
}

