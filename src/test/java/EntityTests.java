import org.example.entities.Entity;
import org.example.entities.Mage;
import org.example.entities.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class EntityTests {

    List<Entity> entities = new ArrayList<>();

    @BeforeEach
    public void prepareData(){
        entities.clear();
        entities.add(new Mage(1));
        entities.add(new Mage(2));
        entities.add(new Warrior(3));
    }

    @Test
    public void isSameType(){
        boolean shouldBeTrue = entities.get(0).checkInstance(entities.get(1));
        boolean shouldBeFalse = entities.get(0).checkInstance(entities.get(2));
        Assertions.assertTrue(shouldBeTrue);
        Assertions.assertFalse(shouldBeFalse);
    }

    @Test
    public void mageAttackOrCrit(){
        entities.get(0).attack(entities.get(1));
        assertThat(entities.get(1).getHp(),anyOf(equalTo(514),equalTo(594)));
    }

    @Test
    public void isDead(){
        Entity entity = entities.get(0);
        Assertions.assertTrue(entity.isAlive());
        //700 mage max hp, 40 armor- dmg reduced by 4;
        entity.takeDamage(704);
        Assertions.assertFalse(entity.isAlive());
    }
}
