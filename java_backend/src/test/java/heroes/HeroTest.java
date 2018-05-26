package heroes;

import org.junit.Before;
import org.junit.Test;
import playField.player.heroes.AbilityType;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

import static org.junit.Assert.*;

public class HeroTest {

    private Hero hero;

    @Before
    public void before() {
        HeroPower heroPower = new HeroPower("", 5, "yes", AbilityType.heal, 0, 0, "", true);
        hero = new Hero("Jaina", "muh img", heroPower);
    }

    @Test
    public void takeDamage(){
            hero.takeDamage(3);
            assertEquals(27, hero.getLifePoints());

            hero.takeDamage(4);
            assertEquals(23, hero.getLifePoints());

            hero.takeDamage(25);
            assertEquals(-2, hero.getLifePoints());
    }

    @Test
    public void isAlive(){
        assertTrue(hero.isAlive());

        hero.takeDamage(30);
        assertFalse(hero.isAlive());
    }
}