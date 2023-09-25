package org.example.map;

import lombok.Getter;
import org.example.entities.Entity;

import java.util.*;

@Getter
public class Ground {

    private final Map<String, List<Entity>> fieldMap;
    private final int size;

    public Ground(int size) {
        fieldMap = new HashMap<>();
        this.size = size;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                fieldMap.put(i + "|" + j, new ArrayList<>());
            }
    }

    public void moveEntities() {
        Random generator = new Random();
        int r;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                int enitiesSize = fieldMap.get(i + "|" + j).size();
                for(int k=0;k<enitiesSize;k++){
                    if (canMove(i, j)) {
                        r = generator.nextInt(4);
                        switch (r) {
                            case 0 -> moveRight(i, j, k);
                            case 1 -> moveLeft(i, j, k);
                            case 2 -> moveUp(i, j, k);
                            case 3 -> moveDown(i, j, k);
                        }
                    }
                }
            }
        }

    }

    public void moveUp(int x, int y, int entityIndex) {
        Entity entity = fieldMap.get(x + "|" + y).get(entityIndex);
        if (y < size - 1) {
            fieldMap.get(x + "|" + (y + 1)).add(entity);
            fieldMap.get(x + "|" + y).remove(entity);
        }
    }

    public void moveDown(int x, int y, int entityIndex) {
        Entity entity = fieldMap.get(x + "|" + y).get(entityIndex);
        if (y > 0) {
            fieldMap.get(x + "|" + (y - 1)).add(entity);
            fieldMap.get(x + "|" + y).remove(entity);
        }
    }

    public void moveLeft(int x, int y, int entityIndex) {
        Entity entity = fieldMap.get(x + "|" + y).get(entityIndex);
        if (x > 0) {
            fieldMap.get((x - 1) + "|" + y).add(entity);
            fieldMap.get(x + "|" + y).remove(entity);
        }
    }

    public void moveRight(int x, int y, int entityIndex) {
        Entity entity = fieldMap.get(x + "|" + y).get(entityIndex);
        if (x < size - 1) {
            fieldMap.get((x + 1) + "|" + y).add(entity);
            fieldMap.get(x + "|" + y).remove(entity);
        }
    }

    // zwraca true jeśli tylko jeden typ jednostki jest na danym polu i false jeśli jest więcej niż 1 typ
    public boolean canMove(int xCoordinate, int yCoordinate) {
        List<Entity> entities = fieldMap.get(xCoordinate + "|" + yCoordinate);
        int index = 0;
        for (Entity entity : entities) {
            if(!entities.get(index).isAlive()&&index<entities.size()-1){
                index++;
            }
            if (entities.get(index).getClass() != entity.getClass()&&entity.isAlive()&&entities.get(index).isAlive()) {
                return false;
            }
        }
        return true;
    }
}
