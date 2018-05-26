package intialize;

import playfield.player.heroes.AbilityType;
import playfield.player.heroes.Hero;
import playfield.player.heroes.HeroPower;
import org.junit.Before;
import org.junit.Test;
import playfield.api.intialize.InitChooseYourHero;

import java.util.List;

import static org.junit.Assert.*;

public class InitChooseYourHeroTest {

    private InitChooseYourHero db;
    private HeroPower heroPower;
    private Hero hero;

    @Before
    public void before() {
        db = new InitChooseYourHero();
        final HeroPower heroPower = new HeroPower(
                "",
                0,
                "",
                AbilityType.heal,
                0,
                0,
                "",
                true
        );
        hero = new Hero("", null, heroPower);
    }

    @Test
    public void getHeroPowerTest() {
        assertEquals(heroPower, db.getHeroPower("Fireblast"));
    }

    @Test
    public void getHeroTest() {
        assertEquals(hero, db.getHero("Mage", null));
    }

    @Test
    public void getPlaybleHeros() {
        final List<Hero> heroList = db.GetPlaybleHeros();
        System.out.println(heroList);
    }
}
