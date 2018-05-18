package player;

import cardCollection.Cards;
import cardCollection.Deck;
import cards.Card;
import cards.CardMinion;
import cards.CardSpell;
import cards.CardWeapon;
import heroes.Hero;
import heroes.HeroPower;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    public Player player;
    private Deck deck;

    @Before
    public void max30cards() {
        deck = new Deck();

        for (int i = 0; i < 30; i++) {
            deck.addCard(new CardMinion("ID" + i, "0", "name", 0, "type", "heroType", "0", 0, 0, "black", "lol"));
        }

        HeroPower heroPower = new HeroPower("", 0, "","",0,0,"",true);
        Hero hero = new Hero("mage", "im", heroPower);

        player = new Player(deck, hero);
    }

    @Test
    public void isCorrectHero() {
        assertEquals("mage", player.getHero().getName());

//        HeroPower heroPower = new HeroPower(0, 0, true);
//        Hero hero1 = new Hero("rogue", "im", heroPower );
//        assertEquals("rogue", hero1.getName());
    }

    @Test
    public void maxTenCardInHand() {
        for (int i = 0; i < 10; i++) {
            player.drawCard();
        }

        assertEquals(10, player.getCardsInHand().getAmount());
        player.drawCard();

        assertEquals(10, player.getCardsInHand().getAmount());

//        for (int i = 0; i < 3; i++) {
//            player.playCard("ID" + i); werkt nie want we trekken random
//        }
//        assertEquals(7, player.getCardsInHand().getAmount());
    }

    @Test
    public void drawCard() {
        for (int i = 0; i < 3; i++) {
            player.drawCard();
        }

        assertEquals(27, player.getDeck().getAmount());
        assertEquals(3,player.getCardsInHand().getAmount());

        for (int i = 0; i < 4; i++) {
            player.drawCard();
        }

        assertEquals(23, player.getDeck().getAmount());
        assertEquals(7,player.getCardsInHand().getAmount());
    }
}