package heroes;

import org.junit.Before;
import org.junit.Test;
import playfield.player.heroes.AbilityType;
import playfield.player.heroes.Hero;
import playfield.player.heroes.heroPower;

import static org.junit.Assert.*;

public class HeroTest {

    private Hero hero;

    @Before
    public void before() {
        final heroPower heroPower = new heroPower("", 5, "yes", AbilityType.heal, 0, 0, "", true);
        hero = new Hero("Jaina", "muh img", heroPower);
    }

    @Test
    public void takeDamage() {
        hero.takeDamage(3);
        assertEquals(27, hero.getLifePoints());

        hero.takeDamage(4);
        assertEquals(23, hero.getLifePoints());

        hero.takeDamage(25);
        assertEquals(-2, hero.getLifePoints());
    }

    @Test
    public void isAlive() {
        assertTrue(hero.isAlive());

        hero.takeDamage(30);
        assertFalse(hero.isAlive());
    }
}
