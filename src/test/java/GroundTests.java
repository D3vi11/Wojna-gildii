import org.example.entities.Archer;
import org.example.entities.Entity;
import org.example.entities.Mage;
import org.example.entities.Warrior;
import org.example.map.Ground;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroundTests {
    private static Ground ground;
    Entity entity;

    @BeforeEach
    public void prepareData() {
        ground = new Ground(5);
        entity = new Mage();
    }

    @Test
    public void correctInitTest() {
        Assertions.assertTrue(ground.getFieldMap().containsKey("4|4"));
    }

    @Test
    public void correctInitFailTest() {
        Assertions.assertFalse(ground.getFieldMap().containsKey("5|5"));
    }

    @Test
    public void moveLeft() {
        ground.getFieldMap().get("1|0").add(entity);
        ground.moveLeft("1|0", 0);
        Assertions.assertEquals(0, ground.getFieldMap().get("1|0").size());
        Assertions.assertEquals(1, ground.getFieldMap().get("0|0").size());
    }

    @Test
    public void moveLeftWall() {
        ground.getFieldMap().get("0|0").add(entity);
        ground.moveLeft("0|0", 0);
        Assertions.assertEquals(1, ground.getFieldMap().get("0|0").size());
    }

    @Test
    public void moveRight() {
        ground.getFieldMap().get("3|0").add(entity);
        ground.moveRight("3|0", 0);
        Assertions.assertEquals(0, ground.getFieldMap().get("3|0").size());
        Assertions.assertEquals(1, ground.getFieldMap().get("4|0").size());
    }

    @Test
    public void moveRightWall() {
        ground.getFieldMap().get("4|0").add(entity);
        ground.moveRight("4|0", 0);
        Assertions.assertEquals(1, ground.getFieldMap().get("4|0").size());
    }

    @Test
    public void moveUp() {
        ground.getFieldMap().get("0|3").add(entity);
        ground.moveUp("0|3", 0);
        Assertions.assertEquals(0, ground.getFieldMap().get("0|3").size());
        Assertions.assertEquals(1, ground.getFieldMap().get("0|4").size());
    }

    @Test
    public void moveUpWall() {
        ground.getFieldMap().get("0|4").add(entity);
        ground.moveUp("0|4", 0);
        Assertions.assertEquals(1, ground.getFieldMap().get("0|4").size());
    }

    @Test
    public void moveDown() {
        ground.getFieldMap().get("0|1").add(entity);
        ground.moveDown("0|1", 0);
        Assertions.assertEquals(0, ground.getFieldMap().get("0|1").size());
        Assertions.assertEquals(1, ground.getFieldMap().get("0|0").size());
    }

    @Test
    public void moveDownWall() {
        ground.getFieldMap().get("0|0").add(entity);
        ground.moveDown("0|0", 0);
        Assertions.assertEquals(1, ground.getFieldMap().get("0|0").size());
    }

    @Test
    public void shouldFight() {
        ground.getFieldMap().get("1|1").add(new Warrior());
        ground.getFieldMap().get("1|1").add(new Archer());
        boolean result = ground.canMove("1|1");
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldntFight() {
        ground.getFieldMap().get("1|1").add(new Warrior());
        ground.getFieldMap().get("1|1").add(new Warrior());
        boolean result = ground.canMove("1|1");
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldntFightBecauseDead() {
        ground.getFieldMap().get("1|1").add(new Warrior());
        ground.getFieldMap().get("1|1").add(new Archer());
        ground.getFieldMap().get("1|1").get(0).setAlive(false);
        boolean result = ground.canMove("1|1");
        Assertions.assertTrue(result);
    }
}
