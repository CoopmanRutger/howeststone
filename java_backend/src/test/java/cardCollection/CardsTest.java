package cardCollection;

import playField.cardCollection.cards.Card;
import playField.cardCollection.cards.CardMinion;
import playField.cardCollection.cards.CardSpell;
import playField.cardCollection.cards.CardWeapon;
import org.junit.Before;
import org.junit.Test;
import playField.cardCollection.Cards;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CardsTest {

    private CardMinion card1;
    private CardWeapon card2;
    private CardSpell card3;
    private Cards cards;

    // TODO als een minion <0 levens heeft dan word hij van spel verwijderd. (rekening houden met deadrattle)
    // TODO als een minion <0 levens heeft dan wordt hij van spel verwijderd. (rekening houden met deathrattle)

    @Before
    public void before() {

//        card1 = new CardMinion("ID", "0", "name", 0, "type", "heroType", "0", 0, 0, "black", "lol");
//        card2 = new CardWeapon("ID", "0", "name", 0, "type", "heroType", "0", 0, 0);
//        card3 = new CardSpell("ID", "0", "name", 0, "type", "heroType", "img", "taunt");
        cards = new Cards();
        System.out.println(cards);


    }

//    public void addAllCards(Cards cards) {
//        for (Card card : cards.getCards()) {
//            this.addCard(card);
//        }
//    }
//    cards.add(card1);

    public void addCard(Card card) {

        cards.addCard(card);
    }


    @Test
    public void addAllCards() {
        cards.addCard(card1);
        cards.addCard(card2);
        cards.addCard(card3);
        System.out.println(cards);

        assertEquals(3, cards.getAmount());

    }


    @Test
    public void adding1() {

        List<Card> list = new ArrayList<>(30);

        list.add(card1);
        list.add(card2);
        list.add(card3);

        cards.addCard(card1);
        cards.addCard(card2);
        cards.addCard(card3);

        assertEquals(list, cards.getCards());
    }

    @Test
    public void adding2() {

        cards.addCard(card1);
        cards.addCard(card2);
        cards.addCard(card3);

        assertEquals(3, cards.getAmount());
    }

    @Test
    public void pop1() {

        cards.addCard(card1);
        assertEquals(1, cards.getAmount());

        cards.drawRandom();
        assertEquals(0, cards.getAmount());
    }

    @Test
    public void pop2() {

        cards.addCard(card1);
        assertEquals(1, cards.getAmount());
    }

    @Test
    public void pop3() {

        cards.addCard(card1);
        assertEquals(card1.getClass(), cards.drawRandom().getClass());

        cards.addCard(card1);
        assertEquals(card1, cards.drawRandom());
    }

    @Test
    public void contains() {

        cards.addCard(card1);
        assertTrue(cards.contains(card1));

        cards.drawRandom();
        assertTrue(!cards.contains(card1));
    }

    @Test
    public void remove() {

        cards.addCard(card1);
        assertEquals(1, cards.getAmount());

        cards.remove(card1);
        assertEquals(0, cards.getAmount());
    }


}