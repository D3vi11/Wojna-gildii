import org.example.entities.Archer;
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

    static List<Entity> entities = new ArrayList<>();

    @BeforeEach
    public void prepareData() {
        for (Entity e : entities) {
            System.out.println(e);
            if (e.isAlive()) {
                e.setHp(0);
                e.takeDamage(40);
            }
        }
        entities.clear();
        entities.add(new Mage());
        entities.add(new Mage());
        entities.add(new Warrior());
    }

    @Test
    public void isSameType() {
        boolean shouldBeTrue = entities.get(0).checkInstance(entities.get(1));
        boolean shouldBeFalse = entities.get(0).checkInstance(entities.get(2));
        Assertions.assertTrue(shouldBeTrue);
        Assertions.assertFalse(shouldBeFalse);
    }

    @Test
    public void mageAttackOrCrit() {
        entities.get(0).attack(entities.get(1));
        assertThat(entities.get(1).getHp(), anyOf(equalTo(514), equalTo(594)));
    }

    @Test
    public void isDead() {
        Entity entity = entities.get(0);
        Assertions.assertTrue(entity.isAlive());
        //700 mage max hp, 40 armor- dmg reduced by 4;
        entity.takeDamage(704);
        Assertions.assertFalse(entity.isAlive());
        System.out.println();
    }

    @Test
    public void isCountCorrect() {
        Mage mage = new Mage();
        Warrior warrior = new Warrior();
        Archer archer = new Archer();
        entities.add(mage);
        entities.add(warrior);
        entities.add(archer);
        Assertions.assertEquals(1, Entity.getArcherCount());
        Assertions.assertEquals(2, Entity.getWarriorCount());
        Assertions.assertEquals(3, Entity.getMageCount());

        mage.setHp(0);
        warrior.setHp(0);
        archer.setHp(0);
        mage.takeDamage(40);
        warrior.takeDamage(40);
        archer.takeDamage(40);

        Assertions.assertEquals(0, Entity.getArcherCount());
        Assertions.assertEquals(1, Entity.getWarriorCount());
        Assertions.assertEquals(2, Entity.getMageCount());

    }
}
