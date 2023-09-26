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

    public void attack(String key) {
        for (int g = 0; g < fieldMap.get(key).size(); g++) {
            for (int z = 0; z < fieldMap.get(key).size(); z++) {
                fieldMap.get(key).get(g).attack(fieldMap.get(key).get(z));
            }
        }
    }

    public boolean moveEntities(String key) {
        Random generator = new Random();
        int r;
        int enitiesSize = fieldMap.get(key).size();
        for (int k = 0; k < enitiesSize; k++) {
            if (!canMove(key)) {
                return false;
            } else {
                r = generator.nextInt(4);
                switch (r) {
                    case 0 -> moveRight(key, k);
                    case 1 -> moveLeft(key, k);
                    case 2 -> moveUp(key, k);
                    case 3 -> moveDown(key, k);
                }
            }
        }
        return true;
    }

    public void moveUp(String key, int entityIndex) {
        Entity entity = fieldMap.get(key).get(entityIndex);
        char[] keyArray = key.toCharArray();
        keyArray[2] = Character.toChars(keyArray[2] + 1)[0];
        if (Integer.parseInt(key.split("\\|")[1]) < size - 1) {
            fieldMap.get(String.valueOf(keyArray)).add(entity);
            fieldMap.get(key).remove(entity);
        }
        entity.setWasMoved(true);
    }

    public void moveDown(String key, int entityIndex) {
        Entity entity = fieldMap.get(key).get(entityIndex);
        char[] keyArray = key.toCharArray();
        keyArray[2] = Character.toChars(keyArray[2] - 1)[0];
        if (Integer.parseInt(key.split("\\|")[1]) > 0) {
            fieldMap.get(String.valueOf(keyArray)).add(entity);
            fieldMap.get(key).remove(entity);
        }
        entity.setWasMoved(true);
    }

    public void moveLeft(String key, int entityIndex) {
        Entity entity = fieldMap.get(key).get(entityIndex);
        char[] keyArray = key.toCharArray();
        keyArray[0] = Character.toChars(keyArray[0] - 1)[0];
        if (Integer.parseInt(key.split("\\|")[0]) > 0) {
            fieldMap.get(String.valueOf(keyArray)).add(entity);
            fieldMap.get(key).remove(entity);
        }
        entity.setWasMoved(true);
    }

    public void moveRight(String key, int entityIndex) {
        Entity entity = fieldMap.get(key).get(entityIndex);
        char[] keyArray = key.toCharArray();
        keyArray[0] = Character.toChars(keyArray[0] + 1)[0];
        if (Integer.parseInt(key.split("\\|")[0]) < size - 1) {
            fieldMap.get(String.valueOf(keyArray)).add(entity);
            fieldMap.get(key).remove(entity);
        }
        entity.setWasMoved(true);
    }

    // zwraca true jeśli tylko jeden typ jednostki jest na danym polu i false jeśli jest więcej niż 1 typ
    public boolean canMove(String key) {
        List<Entity> entities = fieldMap.get(key);
        int index = 0;
        for (Entity entity : entities) {
            if(entity.isWasMoved()){
                return false;
            }
            if (!entities.get(index).isAlive() && index < entities.size() - 1) {
                index++;
            }
            if (entities.get(index).getClass() != entity.getClass() && entity.isAlive() && entities.get(index).isAlive()) {
                return false;
            }
        }
        return true;
    }

    public void resetEntitiesMovement(){
        for (String keys:fieldMap.keySet()) {
            for (Entity entity:fieldMap.get(keys)){
                entity.setWasMoved(false);
            }
        }
    }
}
