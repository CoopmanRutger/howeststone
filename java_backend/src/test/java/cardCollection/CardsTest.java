package cardCollection;

import cards.Card;
import cards.CardMinion;
import cards.CardSpell;
import cards.CardWeapon;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class CardsTest {

    private Cards cards = new Cards();

    private CardMinion card1 = new CardMinion("ID",0,"name","img","type",0);
    private CardWeapon card2 = new CardWeapon("ID",0,"name","img","type",0);
    private CardSpell card3 = new CardSpell("ID",0,"name","img","type");

    @Test
    public void adding() {
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
//        assertEquals(new HashSet<>(card1,card2,card3),"bla");
    }
}