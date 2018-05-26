package intialize;

import org.junit.Before;
import org.junit.Test;
import playField.api.intialize.InitPlayableDeck;

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
        assertNotNull(initPlayableDeck.GetPlayableDeck(noob + "Mage"));
        assertNotNull(initPlayableDeck.GetPlayableDeck(noob + "Priest"));
    }
}
