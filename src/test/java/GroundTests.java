import org.example.entities.Mage;
import org.example.map.Ground;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroundTests {
    static Ground ground;

    @BeforeEach
    public void prepareData() {
        ground = new Ground(5);
    }

    @Test
    public void correctInitTest() {
        try {
            ground.getField(4, 4);
            Assertions.assertTrue(true);
        } catch (ArrayIndexOutOfBoundsException e) {
            Assertions.fail();
        }

    }

    @Test
    public void correctInitFailTest() {
        try {
            ground.getField(5, 5);
            Assertions.fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void moveLeft() {
        ground.getField(1, 0).addUnit(new Mage(1));
        ground.moveLeft(1, 0, 0);
        Assertions.assertEquals(0, ground.getField(1, 0).getEntities().size());
        Assertions.assertEquals(1, ground.getField(0, 0).getEntities().size());
    }

    @Test
    public void moveLeftWall() {
        ground.getField(0, 0).addUnit(new Mage(1));
        ground.moveLeft(0, 0, 0);
        Assertions.assertEquals(1, ground.getField(0, 0).getEntities().size());
    }

    @Test
    public void moveRight() {
        ground.getField(3, 0).addUnit(new Mage(1));
        ground.moveRight(3, 0, 0);
        Assertions.assertEquals(0, ground.getField(3, 0).getEntities().size());
        Assertions.assertEquals(1, ground.getField(4, 0).getEntities().size());
    }

    @Test
    public void moveRightWall() {
        ground.getField(4, 0).addUnit(new Mage(1));
        ground.moveRight(4, 0, 0);
        Assertions.assertEquals(1, ground.getField(4, 0).getEntities().size());
    }

    @Test
    public void moveUp() {
        ground.getField(0, 3).addUnit(new Mage(1));
        ground.moveUp(0, 3, 0);
        Assertions.assertEquals(0, ground.getField(0, 3).getEntities().size());
        Assertions.assertEquals(1, ground.getField(0, 4).getEntities().size());
    }

    @Test
    public void moveUpWall() {
        ground.getField(0, 4).addUnit(new Mage(1));
        ground.moveUp(0, 4, 0);
        Assertions.assertEquals(1, ground.getField(0, 4).getEntities().size());
    }

    @Test
    public void moveDown() {
        ground.getField(0, 1).addUnit(new Mage(1));
        ground.moveDown(0, 1, 0);
        Assertions.assertEquals(0, ground.getField(0, 1).getEntities().size());
        Assertions.assertEquals(1, ground.getField(0, 0).getEntities().size());
    }

    @Test
    public void moveDownWall() {
        ground.getField(0, 0).addUnit(new Mage(1));
        ground.moveDown(0, 0, 0);
        Assertions.assertEquals(1, ground.getField(0, 0).getEntities().size());
    }
}
