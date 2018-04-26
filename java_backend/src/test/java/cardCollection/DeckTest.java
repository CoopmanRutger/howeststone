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
    public void adding1() {
        Deck deck = new Deck();
    }

}