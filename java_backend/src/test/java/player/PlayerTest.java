package player;

import cardCollection.Deck;
import cards.CardMinion;
import cards.CardSpell;
import cards.CardWeapon;
import heroes.Hero;
import heroes.HeroPower;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    private CardMinion card1 = new CardMinion("ID","0","name",0,"type","heroType","0",0,0,"black","lol");
    private CardWeapon card2 = new CardWeapon("ID","0","name",0,"type", "heroType","0");
    private CardSpell card3 = new CardSpell("ID","0","name",0,"type", "heroType","img","taunt");

    private Deck deck = new Deck();

    private HeroPower heroPower = new HeroPower(0,0);
    private Hero hero = new Hero("hero","im", heroPower);

//    @Test
//    public void validation() {
//        deck.addCard(card1);
//        deck.addCard(card2);
//        deck.addCard(card3);
//        Player player = new Player(deck, hero);
//    }

        @Test
    public void drawCard() {
        deck.addCard(card1);
        deck.addCard(card2);
        deck.addCard(card3);
        Player player = new Player(deck, hero);

    }

}