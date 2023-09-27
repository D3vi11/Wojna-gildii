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
        for (int k = 0; k < fieldMap.get(key).size(); k++) {
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
        if (Integer.parseInt(key.split("\\|")[1]) < size - 1) {
            String[] splitKey = key.split("\\|");
            int changedValue = Integer.parseInt(splitKey[1]) + 1;
            fieldMap.get(splitKey[0]+"|"+changedValue).add(entity);
            fieldMap.get(key).remove(entity);
        }
        entity.setWasMoved(true);
    }

    public void moveDown(String key, int entityIndex) {
        Entity entity = fieldMap.get(key).get(entityIndex);
        if (Integer.parseInt(key.split("\\|")[1]) > 0) {
            String[] splitKey = key.split("\\|");
            int changedValue = Integer.parseInt(splitKey[1]) - 1;
            fieldMap.get(splitKey[0]+"|"+changedValue).add(entity);
            fieldMap.get(key).remove(entity);
        }
        entity.setWasMoved(true);
    }

    public void moveLeft(String key, int entityIndex) {
        Entity entity = fieldMap.get(key).get(entityIndex);
        if (Integer.parseInt(key.split("\\|")[0]) > 0) {
            String[] splitKey = key.split("\\|");
            int changedValue = Integer.parseInt(splitKey[0]) - 1;
            fieldMap.get(changedValue+"|"+splitKey[1]).add(entity);
            fieldMap.get(key).remove(entity);
        }
        entity.setWasMoved(true);
    }

    public void moveRight(String key, int entityIndex) {
        Entity entity = fieldMap.get(key).get(entityIndex);
        if (Integer.parseInt(key.split("\\|")[0]) < size - 1) {
            String[] splitKey = key.split("\\|");
            int changedValue = Integer.parseInt(splitKey[0]) + 1;
            fieldMap.get(changedValue+"|"+splitKey[1]).add(entity);
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
