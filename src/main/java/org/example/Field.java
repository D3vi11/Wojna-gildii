package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * \class Pole
 * Klasa pole.
 *
 * Klasa przypisuje wspolrzedne x i y do pola.
 */

public class Field implements Coordinates {

    private final int xCoorinate /**< współrzędna x */, yCoordinate; /**< współrzędna y */
    List<EntityInterface> entities = new ArrayList<>();

    /**
     * Metoda przypisuje wartsoci wspolrzednej x i y.
     * @param xCoorinate parametr przechowujacy wspolrzedna x.
     * @param yCoordinate parametr przechowujacy wspolrzedna y.
     */

    Field(int xCoorinate, int yCoordinate)
    {
        this.xCoorinate = xCoorinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Metoda zwraca wspolrzedna x.
     * @return wspolrzedna x.
     */

    @Override
    public int getX() {
        return xCoorinate;
    }

    /**
     * Metoda zwraca wspolrzedna y.
     * @return wspolrzedna y.
     */

    @Override
    public int getY() {
        return yCoordinate;
    }

    public void addUnit(EntityInterface entity){
        entities.add(entity);
    }

    public EntityInterface getUnit(int index){
        return entities.get(index);
    }

    public void removeUnit(int index){
        entities.remove(index);
    }
    // zwraca true jeśli tylko jeden typ jednostki jest na danym polu i false jeśli jest więcej niż 1 typ
    public boolean checkInstance(){
        boolean warrior = false,archer = false,mage= false;
        for(EntityInterface entity: entities){
            if(entity instanceof Warrior && entity.getAlive()){
                warrior=true;
            }
            if(entity instanceof Archer && entity.getAlive()){
                archer=true;
            }
            if(entity instanceof Mage && entity.getAlive()){
                mage=true;
            }
        }
        if( warrior && archer || warrior && mage || archer && mage ){
            return false;
        }else return true;
    }

    public List<EntityInterface> get_list(){
        return entities;
    }
}
