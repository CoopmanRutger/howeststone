package player;

import playField.cardCollection.Deck;
import playField.cardCollection.cards.CardMinion;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;
import org.junit.Before;
import org.junit.Test;
import playField.player.Player;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private Deck deck;
    private HeroPower heroPower;

    @Before
    public void max30cards() {
        deck = new Deck();

        for (int i = 0; i < 30; i++) {
//            deck.addCard(+new CardMinion("ID" + i, "0", "name", 0, "type", "heroType", "0", 0, 0, "black", "lol"));
        }

//        HeroPower heroPower = new HeroPower("", 0, "","",0,0,"",true);
        Hero hero = new Hero("mage", "im", heroPower);

        player = new Player(deck, hero);
    }

    @Test
    public void isCorrectHero() {
        assertEquals("mage", player.getHero().getName());

        Hero hero1 = new Hero("rogue", "im", heroPower );
        assertEquals("rogue", hero1.getName());
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

    @Test
    public void playCard(){
        player.drawCard();
        player.drawCard();
        player.drawCard();

        System.out.println("blabla");
        System.out.println(player.getCardsInHand());
        System.out.println(player.getCardsOnField());

        player.playCard(player.getCardsInHand().getCards().get(0).getCardId());

        System.out.println("blabla");
        System.out.println(player.getCardsInHand());
        System.out.println(player.getCardsOnField());
    }
}