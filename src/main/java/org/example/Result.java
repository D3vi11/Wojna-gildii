package org.example;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.entities.Archer;
import org.example.entities.Entity;
import org.example.entities.Mage;
import org.example.entities.Warrior;
import org.example.map.Ground;
import java.io.PrintWriter;

@Getter
@RequiredArgsConstructor
class Result {
    @NonNull
    private PrintWriter output;
    public static String inscription;

    public void writeOutput(int entityNumber, PrintWriter output, Ground ground) {
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

        for (int i = 0; i < ground.getSize(); i++) {
            for (int j = 0; j < ground.getSize(); j++) {
                for (int k = 0; k < ground.getFieldMap().get(i+"|"+j).size(); k++) {
                    if (ground.getFieldMap().get(i+"|"+j).get(k).isAlive()) {
                        if (ground.getFieldMap().get(i+"|"+j).get(k) instanceof Warrior)
                            output.println("Jednostka z gildii wojowników nr " + ground.getFieldMap().get(i+"|"+j).get(k).getEntityNumber() + " jest na polu x: " + i + " y: " + j);
                        if (ground.getFieldMap().get(i+"|"+j).get(k) instanceof Archer)
                            output.println("Jednostka z gildii luczników nr " + ground.getFieldMap().get(i+"|"+j).get(k).getEntityNumber() + " jest na polu x: " + i+ " y: " + j);
                        if (ground.getFieldMap().get(i+"|"+j).get(k) instanceof Mage)
                            output.println("Jednostka z gildii Magów nr " + ground.getFieldMap().get(i+"|"+j).get(k).getEntityNumber() + " jest na polu x: " + i + " y: " + j);
                    }
                }
            }
        }
    }

    public String victory() {
        if (Entity.getWarriorCount() == 0 && Entity.getArcherCount() == 0) {
            return "WYGRALI MAGOWIE";
        }
        if (Entity.getWarriorCount() == 0 && Entity.getMageCount() == 0) {
            return "WYGRALI LUCZNICY";
        }
        if (Entity.getArcherCount() == 0 && Entity.getMageCount() == 0) {
            return "WYGRALI WOJOWNICY";
        }
        return "WALKA NIEROZSTRZYGNIĘTA";
    }

    public void writeBasicOutput(int entityNumber,Ground ground,int currentIteration){
        output.println(" ");
        output.println("ITERACJA NR " + (currentIteration + 1));
        output.println(" ");
        writeOutput(entityNumber, output, ground);
        inscription = victory();
        //if (!inscription.isEmpty() && !inscription.equals("WALKA NIEROZSTRZYGNIĘTA")) break;
    }

    public void closeFile(){
        output.close();
    }
}
