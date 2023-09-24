package org.example.map;

import lombok.Getter;
import org.example.entities.Archer;
import org.example.entities.Entity;
import org.example.entities.Mage;
import org.example.entities.Warrior;

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
                fieldMap.put(i+"|"+j,new ArrayList<>());
            }
    }
    public void moveEntities() {
        Random generator = new Random();
        int r;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                for (int k = 0; k < fieldMap.get(i+"|"+j).size(); k++) {
                    if(canMove(i,j)){
                        r = generator.nextInt(4);
                        switch (r) {
                            case 0-> moveRight(i,j,k);
                            case 1-> moveLeft(i,j,k);
                            case 2-> moveUp(i,j,k);
                            case 3-> moveDown(i,j,k);
                        }
                    }
                }
    }
    public void moveUp(int x, int y, int k){
        if (y < size-1) {
            fieldMap.get(x+"|"+(y+1)).add(fieldMap.get(x+"|"+y).get(k));
            fieldMap.get(x+"|"+y).remove(k);
        }
    }
    public void moveDown(int x, int y, int k){
        if (y > 0) {
            fieldMap.get(x+"|"+(y-1)).add(fieldMap.get(x+"|"+y).get(k));
            fieldMap.get(x+"|"+y).remove(k);
        }
    }
    public void moveLeft(int x, int y, int k){
        if (x > 0) {
            fieldMap.get((x-1)+"|"+y).add(fieldMap.get(x+"|"+y).get(k));
            fieldMap.get(x+"|"+y).remove(k);
        }
    }
    public void moveRight(int x, int y, int k){
        if (x < size-1) {
            fieldMap.get((x+1)+"|"+y).add(fieldMap.get(x+"|"+y).get(k));
            fieldMap.get(x+"|"+y).remove(k);
        }
    }
    // zwraca true jeśli tylko jeden typ jednostki jest na danym polu i false jeśli jest więcej niż 1 typ
    public boolean canMove(int x, int y) {
        boolean warrior = false, archer = false, mage = false;
        for (Entity entity : fieldMap.get(x+"|"+y)) {
            if (entity instanceof Warrior && entity.isAlive()) {
                warrior = true;
            }
            if (entity instanceof Archer && entity.isAlive()) {
                archer = true;
            }
            if (entity instanceof Mage && entity.isAlive()) {
                mage = true;
            }
        }
        if (warrior && archer || warrior && mage || archer && mage) {
            return false;
        } else return true;
    }
}
