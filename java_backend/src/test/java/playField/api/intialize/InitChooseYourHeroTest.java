package playField.api.intialize;

import org.junit.Before;
import org.junit.Test;
import playField.player.PlayableDeck;
import playField.player.heroes.Hero;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class InitChooseYourHeroTest {

    public InitChooseYourHero initChooseYourHero;

    @Before
    public void before() {
        initChooseYourHero = new InitChooseYourHero();
    }


    @Test
    public void GetPlaybleHeros() {
        List<Hero> blabla = initChooseYourHero.GetPlaybleHeros();
        System.out.println(blabla);
    }
}
