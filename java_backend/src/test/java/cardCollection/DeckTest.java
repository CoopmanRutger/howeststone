package cardCollection;

import cards.Card;
import cards.CardMinion;
import cards.CardSpell;
import cards.CardWeapon;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class DeckTest {

    private CardMinion card1 = new CardMinion("ID","0","name",0,"type","heroType","0",0,0,"black","lol");
    private CardWeapon card2 = new CardWeapon("ID","0","name",0,"type", "heroType","0");
    private CardSpell card3 = new CardSpell("ID","0","name",0,"type", "heroType","img","taunt");

    @Test
    public void adding() {
        Deck deck = new Deck();

        deck.addCards(card1);
        assertEquals(1,deck.getAmount());
        deck.addCards(card1);
        assertEquals(2,deck.getAmount());
        deck.addCards(card1);
        assertEquals(2,deck.getAmount());
        deck.addCards(card2);
        assertEquals(3,deck.getAmount());
    }

    @Test
    public void pop() {
        Deck deck = new Deck();

        deck.addCards(card1);
        deck.addCards(card1);
        deck.addCards(card2);
        deck.addCards(card3);

        assertEquals(4,deck.getAmount());

        assertEquals(card1.getClass(),deck.pop().getClass());
        assertEquals(3,deck.getAmount());

        deck.pop();
        assertEquals(2,deck.getAmount());

        deck.pop();
        assertEquals(1,deck.getAmount());

        deck.pop();
        assertEquals(0,deck.getAmount());
    }
}