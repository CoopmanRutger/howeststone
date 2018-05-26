package playfield.api.intialize;

import org.junit.Before;
import org.junit.Test;
import playfield.player.heroes.Hero;

import java.util.List;

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
