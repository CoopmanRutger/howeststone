package intialize;

import org.junit.Before;
import org.junit.Test;
import playfield.api.intialize.InitPlayableDeck;

import static org.junit.Assert.*;

public class InitPlayableDeckTest {

    public InitPlayableDeck initPlayableDeck;

    @Before
    public void before() {
        initPlayableDeck = new InitPlayableDeck();
    }



    @Test
    public void getPlayableDecksByHeroname() {
//        Set<PlayableDeck> blabla = initPlayableDeck.GetPlayableDecksByHeroname("Mage");
//        System.out.println(blabla);
        assertNotNull(new InitPlayableDeck().GetPlayableDeck("noob" + "Mage"));
        assertNotNull(new InitPlayableDeck().GetPlayableDeck("noob" + "Priest"));
        System.out.println(new InitPlayableDeck().GetPlayableDeck("noob" + "Mage"));
        System.out.println(new InitPlayableDeck().GetPlayableDeck("noob" + "Priest"));
    }
}