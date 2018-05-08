package playingfield;

import cardCollection.Deck;
import cards.CardMinion;
import heroes.Hero;
import heroes.HeroPower;
import org.junit.Before;
import org.junit.Test;
import player.Player;
import playField.PlayingField;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Playingfield {

    public Player player;
    public Player opponent;
    public PlayingField testField;

    @Before
    public void hmm() {
        Deck deck = new Deck();
        int number = 10;
        for (int i = 0; i < number; i++) {
            deck.addCard(new CardMinion("ID" + i, "0", "name", 2, "mage", "heroType", "0", 2, 2, "black", "lol"));
            deck.addCard(new CardMinion("ID" + 1 + i, "0", "name", 1, "warrior", "heroType", "0", 1, 3, "white", "lol"));
            deck.addCard(new CardMinion("ID" + 2 + i, "0", "name", 1, "mage", "heroType", "0", 3, 0, "asian", "lol"));

        }
        HeroPower heroPower = new HeroPower(0, 0, true);
        Hero hero = new Hero("mage", "im", heroPower);

        player = new Player(deck, hero);
        opponent = new Player(deck, hero);

        Player players[] = new Player[2];
        PlayingField testField = new PlayingField(player,opponent, true);
        // TODO minion met 3 mana kan niet gespeeld worden als je maar 2 mana hebt.
        // TODO als je 5 mana heb en je speelt een kaart van 2 mana, erna nog een kaart van 2, heb je nog 1 mana over.
        // TODO als end turn is true kan de speler niets doen.
        // TODO als end turn is false kan je wel bepaalde dingen doen.
        // TODO (vodoo docter) als minion 1 leven af is en je hersteld met 2 levens krijgt hij toch maar 1 leven bij.
        // TODO minion wordt aangevallen en heeft < 0 levens dus wordt van veld verwijderd.

    }

    @Test
    public void name() {

        testField.increment();
        testField.getMana();
    }

    @Test
    public void checkIfItsYourTurn() {

        System.out.println();

    }


    

    @Test
    public void heroStartGame() {

        assertEquals(30, player.getHero().getLifePoints());
        assertEquals(0, player.getHero().getAmourPoints());

    }


    @Test
    public void heroGetsAmour() {
        player.getHero().setAmourPoints(5);
        assertEquals(5, player.getHero().getAmourPoints());
    }

    @Test
    public void heroGetHits() {

        player.getHero().takeDamage(3);
        assertEquals(27, player.getHero().getLifePoints());
        assertTrue(player.isAlive());

        player.getHero().takeDamage(4);
        assertEquals(23, player.getHero().getLifePoints());
        assertTrue(player.isAlive());

        player.getHero().takeDamage(25);
        assertEquals(-2,player.getHero().getLifePoints());
        assertFalse(player.isAlive());

    }


}
