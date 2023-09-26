package org.example;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.entities.Archer;
import org.example.entities.Entity;
import org.example.entities.Mage;
import org.example.entities.Warrior;
import org.example.map.Ground;

import java.awt.EventQueue;
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

    public void run(){
        //fill map with entities
        fillGround();

        //initialize file
        try{
            result= new Result(new PrintWriter("Wyniki.txt"));
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }


        for (int i = 0; i < iterationNumber; i++) {
            moveAndFight();
            // write to file
            result.writeBasicOutput(entityNumber,ground,i);
        }

        //close file
        result.closeFile();
    }

    private static int randomize(int mapSize) {
        Random random = new Random();
        return random.nextInt(mapSize);
    }

    public void moveAndFight() {
        ground.resetEntitiesMovement();
        for (String key : ground.getFieldMap().keySet()) {
            //move entities
            ground.moveEntities(key);
            //attack
            //ground.attack(key);
        }
    }

    public void fillGround() {
        ground = new Ground(mapSize);
        int x, y;
        for (int i = 0; i < entityNumber; i++) {
            System.out.println(i);
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getFieldMap().get(x + "|" + y).add(new Warrior());
            System.out.println(Entity.getWarriorCount());
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getFieldMap().get(x + "|" + y).add(new Archer());
            System.out.println(Entity.getArcherCount());
            x = randomize(mapSize);
            y = randomize(mapSize);
            ground.getFieldMap().get(x + "|" + y).add(new Mage());
            System.out.println(Entity.getMageCount());
        }
    }
}

