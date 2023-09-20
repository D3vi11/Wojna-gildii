import org.example.entities.Archer;
import org.example.entities.Warrior;
import org.example.map.Field;
import org.junit.Assert;
import org.junit.Test;

public class FieldTests {

    Field field;


    @Test
    public void shouldFight() {
        field = new Field();
        field.addUnit(new Warrior(1));
        field.addUnit(new Archer(2));
        boolean result = field.checkIfShouldFight();
        System.out.println(result);
        field.removeUnit(1);
        field.removeUnit(0);
        Assert.assertFalse(result);
    }

    @Test
    public void shouldntFight() {
        field = new Field();
        field.addUnit(new Warrior(1));
        field.addUnit(new Warrior(2));
        boolean result = field.checkIfShouldFight();
        System.out.println(result);
        field.removeUnit(1);
        field.removeUnit(0);
        Assert.assertTrue(result);
    }
}
