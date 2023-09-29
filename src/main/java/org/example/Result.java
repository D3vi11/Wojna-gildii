package org.example;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.entities.*;
import org.example.map.Ground;

import java.io.PrintWriter;

@Getter
@RequiredArgsConstructor
public class Result {
    @NonNull
    private PrintWriter output;
    public static String inscription;

    public void writeEntitiesLifeStatus(int entityNumber) {
        int deadWarriorsCount = entityNumber - Entity.getWarriorCount();
        int deadArchersCount = entityNumber - Entity.getArcherCount();
        int deadMagesCount = entityNumber - Entity.getMageCount();
        output.println("Liczba jednostek gildii wojownikow: " + entityNumber);
        output.println("Ilosc zywych jednostek = " + Entity.getWarriorCount());
        output.println("Ilosc martwych jednostek = " + deadWarriorsCount);
        output.println("Liczba jednostek gildii łuczników: " + entityNumber);
        output.println("Ilosc zywych jednostek = " + Entity.getArcherCount());
        output.println("Ilosc martwych jednostek = " + deadArchersCount);
        output.println("Liczba jednostek gildii magów: " + entityNumber);
        output.println("Ilosc zywych jednostek = " + Entity.getMageCount());
        output.println("Ilosc martwych jednostek = " + deadMagesCount);
    }

    public void writeEntitiesPositionAndHp(Ground ground) {
        for (String key : ground.getFieldMap().keySet()) {
            for (Entity entity : ground.getFieldMap().get(key)) {
                if (entity.isAlive()) {
                    String[] coordinates = key.split("\\|");
                    EntityTypeEnum entityTypeEnum = EntityTypeEnum.WARRIOR;
                    if (entity instanceof Warrior){
                        entityTypeEnum = EntityTypeEnum.WARRIOR;
                    }else if (entity instanceof Archer){
                        entityTypeEnum = EntityTypeEnum.ARCHER;
                    }else if (entity instanceof Mage){
                        entityTypeEnum = EntityTypeEnum.MAGE;
                    }
                    output.println("Jednostka z gildii "+ entityTypeEnum.getValue() +" nr " + entity.getEntityNumber() + " jest na polu x: " + coordinates[0] + " y: " + coordinates[1]+" i ma: "+entity.getHp()+"/"+entity.getMaxHp()+" Hp");
                }
            }
        }
    }

    public boolean victory() {
        if (Entity.getWarriorCount() == 0 && Entity.getArcherCount() == 0) {
            inscription = "WYGRALI MAGOWIE";
            return true;
        }
        if (Entity.getWarriorCount() == 0 && Entity.getMageCount() == 0) {
            inscription = "WYGRALI LUCZNICY";
            return true;
        }
        if (Entity.getArcherCount() == 0 && Entity.getMageCount() == 0) {
            inscription = "WYGRALI WOJOWNICY";
            return true;
        }
        inscription = "WALKA NIEROZSTRZYGNIĘTA";
        return false;
    }

    public void writeOutput(int entityNumber, Ground ground, int currentIteration) {
        output.println(" ");
        output.println("ITERACJA NR " + (currentIteration + 1));
        output.println(" ");
        writeEntitiesLifeStatus(entityNumber);
        writeEntitiesPositionAndHp(ground);
    }

    public void closeFile() {
        output.close();
    }
}
