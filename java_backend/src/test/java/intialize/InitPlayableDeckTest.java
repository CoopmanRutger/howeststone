package intialize;

import org.junit.Before;
import org.junit.Test;
import playField.api.intialize.InitPlayableDeck;
import playField.player.PlayableDeck;

import java.util.Set;

import static org.junit.Assert.*;

public class InitPlayableDeckTest {

    public InitPlayableDeck initPlayableDeck;

    @Before
    public void before() {
        initPlayableDeck = new InitPlayableDeck();
    }



    @Test
    public void getPlayableDecksByHeroname() {
        Set<PlayableDeck> blabla = initPlayableDeck.GetPlayableDecksByHeroname("Mage");
        System.out.println(blabla);

    }
}