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

    private Cards cards = new Cards();

    private CardMinion card1 = new CardMinion("ID","0","name",0,"type","heroType","0",0,0,"black","lol");
    private CardWeapon card2 = new CardWeapon("ID","0","name",0,"type", "heroType","0");
    private CardSpell card3 = new CardSpell("ID","0","name",0,"type", "heroType","img","taunt");

    @Test
    public void adding() {
        Set<Card> set = new HashSet<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        assertEquals(set,"bla");
    }
}