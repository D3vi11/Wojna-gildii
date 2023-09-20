package org.example.map;

import java.util.Random;

public class Ground {

    private Field[][] fieldTable;
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

    public int gerNumberOfFields() {
        return size ^ 2;
    }

    public int getSize() {
        return size;
    }

    public void move(int size) {
        Random generator = new Random();
        int r;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                for (int k = 0; k < fieldTable[i][j].getEntities().size(); k++) {
                    r = generator.nextInt(4);
                    switch (r) {
                        case 0: {
                            if (i < size-1) {
                                fieldTable[i + 1][j].addUnit(fieldTable[i][j].getUnit(k));
                                fieldTable[i][j].removeUnit(k);
                            }
                        }
                        break;
                        case 1: {
                            if (i > 0) {
                                fieldTable[i - 1][j].addUnit(fieldTable[i][j].getUnit(k));
                                fieldTable[i][j].removeUnit(k);
                            }
                        }
                        break;
                        case 2: {
                            if (j < size-1) {
                                fieldTable[i][j + 1].addUnit(fieldTable[i][j].getUnit(k));
                                fieldTable[i][j].removeUnit(k);
                            }
                        }
                        break;
                        case 3: {
                            if (j > 0) {
                                fieldTable[i][j - 1].addUnit(fieldTable[i][j].getUnit(k));
                                fieldTable[i][j].removeUnit(k);
                            }
                        }
                        break;
                    }
                }
    }
}
