package heroes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    private HeroPower heroPower;
    private Hero hero;

    @Before
    public void before() {
        Hero test = new Hero("Jaina", "muh img", heroPower);


    }

    @Test
    public void takeDamage(int damage){

            hero.takeDamage(3);
            assertEquals(27, hero.getLifePoints());

            hero.takeDamage(4);
            assertEquals(23, hero.getLifePoints());

            hero.takeDamage(25);
            assertEquals(-2, hero.getLifePoints());
        }
    }
}