package intialize;

import heroes.Hero;
import heroes.HeroPower;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InitChooseYourHeroTest {

    InitChooseYourHero db;
    private HeroPower heroPower;
    private Hero hero;

    @Before
    public void before() {
        db = new InitChooseYourHero();
        heroPower = new HeroPower("Fireblast", 2, "Targeted", "damage", 2, 1, null, true);
        hero = new Hero("Mage", null, heroPower);
    }


    @Test
    public void getHeroPowerTest() {
        assertEquals(heroPower   , db.getHeroPower("Fireblast"));
    }
    @Test
    public void getHeroTest() {
        assertEquals(hero, db.getHero("Mage", heroPower));
    }
}