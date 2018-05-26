package player;

import playField.cardCollection.Deck;
import playField.cardCollection.cards.CardAbility;
import playField.cardCollection.cards.CardMinion;
import playField.player.heroes.AbilityType;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;
import org.junit.Before;
import org.junit.Test;
import playField.player.Player;

import java.util.HashSet;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private Deck deck;
    private HeroPower heroPower;

    @Before
    public void max30cards() {
        deck = new Deck();

        for (int i = 0; i < 30; i++) {
            final CardMinion card = new CardMinion(
                    "ID" + 2 + i,
                    "",
                    "name",
                    1,
                    "",
                    "heroType",
                    "0", 3,
                    0,
                    "asian",
                    "lol",
                    new HashSet<CardAbility>()
            );
            deck.addCard(card);
        }

        final HeroPower heroPower = new HeroPower(
                "",
                0,
                "",
                AbilityType.heal,
                0,
                0,
                "",
                true
        );
        final Hero hero = new Hero("", "img", heroPower);

        player = new Player(deck, hero);
    }

    @Test
    public void isCorrectHero() {
        assertEquals("", player.getHero().getName());

        final String temp = "rogue";

        final Hero hero1 = new Hero(temp, "im", heroPower);
        assertEquals(temp, hero1.getName());
    }

    @Test
    public void maxTenCardInHand() {
        for (int i = 0; i < 10; i++) {
            player.drawCard();
        }

        assertEquals(10, player.getCardsInHand().getAmount());
        player.drawCard();

        assertEquals(10, player.getCardsInHand().getAmount());

        for (int i = 0; i < 3; i++) {
            player.playCard(player.getCardsInHand().getCards().get(0).getCardId());
        }
        assertEquals(7, player.getCardsInHand().getAmount());
    }

    @Test
    public void drawCard() {
        for (int i = 0; i < 3; i++) {
            player.drawCard();
        }

        assertEquals(27, player.getDeck().getAmount());
        assertEquals(3, player.getCardsInHand().getAmount());

        for (int i = 0; i < 4; i++) {
            player.drawCard();
        }

        assertEquals(23, player.getDeck().getAmount());
        assertEquals(7, player.getCardsInHand().getAmount());
    }

    @Test
    public void playCard() {
        player.drawCard();
        player.drawCard();
        player.drawCard();

        player.playCard(player.getCardsInHand().getCards().get(0).getCardId());
    }
}
