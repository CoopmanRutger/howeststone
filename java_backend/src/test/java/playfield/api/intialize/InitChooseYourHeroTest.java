package field.api.intialize;

import org.junit.Before;
import org.junit.Test;
import field.player.heroes.Hero;

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
