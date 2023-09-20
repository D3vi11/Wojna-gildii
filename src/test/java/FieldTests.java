import org.example.entities.Archer;
import org.example.entities.Warrior;
import org.example.map.Field;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FieldTests {

    Field field=new Field();

    @AfterEach
    public void cleanup(){
        field.removeUnit(1);
        field.removeUnit(0);
    }


    @Test
    public void shouldFight() {
        field.addUnit(new Warrior(1));
        field.addUnit(new Archer(2));
        boolean result = field.canMove();
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldntFight() {
        field.addUnit(new Warrior(1));
        field.addUnit(new Warrior(2));
        boolean result = field.canMove();
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldntFightBecauseDead(){
        field.addUnit(new Warrior(1));
        field.addUnit(new Archer(2));
        field.getUnit(0).setAlive(false);
        boolean result = field.canMove();
        Assertions.assertTrue(result);
    }
}
