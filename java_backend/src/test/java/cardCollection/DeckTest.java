//package cardCollection;
//
//import playField.cardCollection.cards.CardMinion;
//import playField.cardCollection.cards.CardSpell;
//import playField.cardCollection.cards.CardWeapon;
//import org.junit.Test;
//import playField.cardCollection.Deck;
//
//import static org.junit.Assert.*;
//
//public class DeckTest {
//
////    private CardMinion card1 = new CardMinion("ID","0","name",0,"type","heroType","0",0,0,"black","lol");
////    private CardWeapon card2 = new CardWeapon("ID","1","name",0,"type", "heroType","0", 0, 0);
////    private CardSpell card3 = new CardSpell("ID","0","name",0,"type", "heroType","img","taunt");/
//
//    @Test
//    public void adding() {
//        Deck deck = new Deck();
//
//        deck.addCard(card1);
//        assertEquals(1,deck.getAmount());
//        deck.addCard(card1);
//        assertEquals(2,deck.getAmount());
//        deck.addCard(card1);
//        assertEquals(2,deck.getAmount());
//        deck.addCard(card2);
//        assertEquals(3,deck.getAmount());
//    }
//
//    @Test
//    public void pop() {
//        Deck deck = new Deck();
//
//        deck.addCard(card1);
//        deck.addCard(card1);
//        deck.addCard(card2);
//        deck.addCard(card3);
//
//        assertEquals(4,deck.getAmount());
//
//        deck.drawRandom();
//        assertEquals(3,deck.getAmount());
//
//        deck.drawRandom();
//        assertEquals(2,deck.getAmount());
//
//        deck.drawRandom();
//        assertEquals(1,deck.getAmount());
//
//        deck.drawRandom();
//        assertEquals(0,deck.getAmount());
//    }
//
//    @Test
//    public void thirtyLimit() {
//        Deck deck = new Deck();
//        assertTrue(!deck.valid());
//    }
//}