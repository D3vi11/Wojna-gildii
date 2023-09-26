import org.example.Guild;
import org.example.entities.Entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuildTests {

    Guild guild = new Guild(100,1,1);

    @Test
    public void areEntitiesCreated(){
        Assertions.assertEquals(0,Entity.getArcherCount());
        Assertions.assertEquals(0,Entity.getMageCount());
        Assertions.assertEquals(0,Entity.getWarriorCount());
        guild.fillGround();
        Assertions.assertEquals(100,Entity.getArcherCount());
        Assertions.assertEquals(100,Entity.getMageCount());
        Assertions.assertEquals(100,Entity.getWarriorCount());
    }
}
