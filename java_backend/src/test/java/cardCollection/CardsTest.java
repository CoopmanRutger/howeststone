package cardCollection;

import cards.Card;
import cards.CardMinion;
import cards.CardSpell;
import cards.CardWeapon;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CardsTest {

    private CardMinion card1 = new CardMinion("ID","0","name",0,"type","heroType","0",0,0,"black","lol");
    private CardWeapon card2 = new CardWeapon("ID","0","name",0,"type", "heroType","0");
    private CardSpell card3 = new CardSpell("ID","0","name",0,"type", "heroType","img","taunt");

    @Test
    public void adding1() {
        Cards cards = new Cards();

        Set<Card> set = new HashSet<>();

        set.add(card1);
        set.add(card2);
        set.add(card3);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        assertEquals(set,cards.getCards());
    }

    @Test
    public void adding2() {
        Cards cards = new Cards();

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        assertEquals(3,cards.getAmountOfCards());
    }

    @Test
    public void adding3() {
        Cards cards = new Cards();

        cards.add(card1);
        cards.add(card1);

        assertEquals(1,cards.getAmountOfCards());
    }

    @Test
    public void pop1() {
        Cards cards = new Cards();

        cards.add(card1);
        assertEquals(1,cards.getAmountOfCards());
        
        cards.pop();
        assertEquals(0,cards.getAmountOfCards());
    }

    @Test
    public void pop2() {
        Cards cards = new Cards();

        cards.add(card1);
        assertEquals(1,cards.getAmountOfCards());
    }

    @Test
    public void pop3() {
        Cards cards = new Cards();

        cards.add(card1);
        assertEquals(card1.getClass(),cards.pop().getClass());

        cards.add(card1);
        assertEquals(card1,cards.pop());
    }
}