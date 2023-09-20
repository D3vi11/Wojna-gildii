package org.example.map;

import org.example.entities.Archer;
import org.example.entities.Entity;
import org.example.entities.Mage;
import org.example.entities.Warrior;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private final int xCoordinate;
    private final int yCoordinate;
    List<Entity> entities = new ArrayList<>();


    public Field(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getX() {
        return xCoordinate;
    }


    public int getY() {
        return yCoordinate;
    }

    public void addUnit(Entity entity) {
        entities.add(entity);
    }

    public Entity getUnit(int index) {
        return entities.get(index);
    }

    public void removeUnit(int index) {
        entities.remove(index);
    }

    // zwraca true jeśli tylko jeden typ jednostki jest na danym polu i false jeśli jest więcej niż 1 typ
    public boolean checkInstance() {
        boolean warrior = false, archer = false, mage = false;
        for (Entity entity : entities) {
            if (entity instanceof Warrior && entity.getAlive()) {
                warrior = true;
            }
            if (entity instanceof Archer && entity.getAlive()) {
                archer = true;
            }
            if (entity instanceof Mage && entity.getAlive()) {
                mage = true;
            }
        }
        if (warrior && archer || warrior && mage || archer && mage) {
            return false;
        } else return true;
    }

    public List<Entity> get_list() {
        return entities;
    }
}
