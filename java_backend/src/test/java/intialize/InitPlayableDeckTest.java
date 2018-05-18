package intialize;

import heroes.Hero;
import heroes.HeroPower;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InitPlayableDeckTest {

    public InitPlayableDeck playableDeck;

    @Before
    public void before() {
        playableDeck = new InitPlayableDeck();
    }


    @Test
    public void getPlayableDecks() {
        assertNotNull(playableDeck.GetPlayableDecks());

    }

    @Test
    public void makePlaybleDeck() {
    }

    @Test
    public void getPlayableDeck() {
    }

    @Test
    public void setPlayableDeck() {
    }
}