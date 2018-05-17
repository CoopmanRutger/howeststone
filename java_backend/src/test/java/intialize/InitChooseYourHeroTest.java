package intialize;

import heroes.Hero;
import heroes.HeroPower;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InitChooseYourHeroTest {

    InitChooseYourHero db;

    @Before
    public void before() {
        db = new InitChooseYourHero();
    }

    @Test
    public void getHeroPowerTest() {
        HeroPower heroPower = db.getHeroPower("Fireblast");

    }
    @Test
    public void getHeroTest() {
        Hero hero = db.getHero("Mage");

    }
}