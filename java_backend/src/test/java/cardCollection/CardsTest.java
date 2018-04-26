package cardCollection;

import cards.Card;
import cards.CardMinion;
import cards.CardSpell;
import cards.CardWeapon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class CardsTest {

    private CardMinion card1 = new CardMinion("ID","0","name",0,"type","heroType","0",0,0,"black","lol");
    private CardWeapon card2 = new CardWeapon("ID","0","name",0,"type", "heroType","0");
    private CardSpell card3 = new CardSpell("ID","0","name",0,"type", "heroType","img","taunt");

    @Test
    public void adding1() {
        Cards cards = new Cards();

        List<Card> list = new ArrayList<>(30);

        list.add(card1);
        list.add(card2);
        list.add(card3);

        cards.addCard(card1);
        cards.addCard(card2);
        cards.addCard(card3);

        assertEquals(list,cards.getCards());
    }

    @Test
    public void adding2() {
        Cards cards = new Cards();

        cards.addCard(card1);
        cards.addCard(card2);
        cards.addCard(card3);

        assertEquals(3,cards.getAmount());
    }

    @Test
    public void pop1() {
        Cards cards = new Cards();

        cards.addCard(card1);
        assertEquals(1,cards.getAmount());
        
        cards.drawRandom();
        assertEquals(0,cards.getAmount());
    }

    @Test
    public void pop2() {
        Cards cards = new Cards();

        cards.addCard(card1);
        assertEquals(1,cards.getAmount());
    }

    @Test
    public void pop3() {
        Cards cards = new Cards();

        cards.addCard(card1);
        assertEquals(card1.getClass(),cards.drawRandom().getClass());

        cards.addCard(card1);
        assertEquals(card1,cards.drawRandom());
    }

    @Test
    public void contains() {
        Cards cards = new Cards();

        cards.addCard(card1);
        assertTrue(cards.contains(card1));

        cards.drawRandom();
        assertTrue(!cards.contains(card1));
    }

    @Test
    public void remove() {
        Cards cards = new Cards();

        cards.addCard(card1);
        assertEquals(1,cards.getAmount());

        cards.remove(card1);
        assertEquals(0,cards.getAmount());
    }
}