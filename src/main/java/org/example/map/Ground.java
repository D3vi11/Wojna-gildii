package org.example.map;

import java.util.Random;

public class Ground {

    private final Field[][] fieldTable;
    private final int size;

    public Ground(int size) {
        this.size = size;
        fieldTable = new Field[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                fieldTable[i][j] = new Field();
            }
    }

    public Field[][] getFieldTable() {
        return fieldTable;
    }

    public Field getField(int x, int y) {
        return fieldTable[x][y];
    }

    public int getSize() {
        return size;
    }

    public void moveEntities() {
        Random generator = new Random();
        int r;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                for (int k = 0; k < fieldTable[i][j].getEntities().size(); k++) {
                    if(fieldTable[i][j].canMove()){
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
            fieldTable[x][y + 1].addUnit(fieldTable[x][y].getUnit(k));
            fieldTable[x][y].removeUnit(k);
        }
    }
    public void moveDown(int x, int y, int k){
        if (y > 0) {
            fieldTable[x][y - 1].addUnit(fieldTable[x][y].getUnit(k));
            fieldTable[x][y].removeUnit(k);
        }
    }
    public void moveLeft(int x, int y, int k){
        if (x > 0) {
            fieldTable[x - 1][y].addUnit(fieldTable[x][y].getUnit(k));
            fieldTable[x][y].removeUnit(k);
        }
    }
    public void moveRight(int x, int y, int k){
        if (x < size-1) {
            fieldTable[x + 1][y].addUnit(fieldTable[x][y].getUnit(k));
            fieldTable[x][y].removeUnit(k);
        }
    }
}
