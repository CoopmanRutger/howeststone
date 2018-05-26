package intialize;

import org.junit.Before;
import org.junit.Test;
import playfield.api.intialize.InitPlayableDeck;

import static org.junit.Assert.*;

public class InitPlayableDeckTest {

    private InitPlayableDeck initPlayableDeck;

    @Before
    public void before() {
        initPlayableDeck = new InitPlayableDeck();
    }

    @Test
    public void getPlayableDecksByHeroname() {
        final String noob = "noob";
        assertNotNull(initPlayableDeck.getPlayableDeck(noob + "Mage"));
        assertNotNull(initPlayableDeck.getPlayableDeck(noob + "Priest"));
    }
}
