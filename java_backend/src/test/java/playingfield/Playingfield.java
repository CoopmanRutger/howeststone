//package playingfield;
//
//import playField.cardCollection.Deck;
//import playField.cardCollection.cards.CardMinion;
//import org.junit.Before;
//import org.junit.Test;
//import playField.player.Player;
//import playField.PlayingField;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class Playingfield {
//
//    public Player player;
//    public Player opponent;
//    public PlayingField testField;
//
//    @Before
//    public void hmm() {
//        Deck deck = new Deck();
//        for (int i = 0; i < 10; i++) {
//            deck.addCard(new CardMinion("ID" + i, "0", "name", 2, "mage", "heroType", "0", 2, 2, "black", "lol"));
//            deck.addCard(new CardMinion("ID" + 1 + i, "0", "name", 1, "warrior", "heroType", "0", 1, 3, "white", "lol"));
//            deck.addCard(new CardMinion("ID" + 2 + i, "0", "name", 1, "mage", "heroType", "0", 3, 0, "asian", "lol"));
//        }
//
////        HeroPower heroPower = new HeroPower(0, 0, true);
////        Hero hero = new Hero("mage", "im", heroPower);
//
////        player = new Player(deck, hero);
////        opponent = new Player(deck, hero);
//
//        testField = new PlayingField(player, opponent);
//        // TODO minion met 3 mana kan niet gespeeld worden als je maar 2 mana hebt.
//        // TODO als je 5 mana heb en je speelt een kaart van 2 mana, erna nog een kaart van 2, heb je nog 1 mana over.
//        // TODO als end turn is true kan de speler niets doen.
//        // TODO als end turn is false kan je wel bepaalde dingen doen.
//        // TODO (vodoo docter) als minion 1 leven af is en je hersteld met 2 levens krijgt hij toch maar 1 leven bij.
//        // TODO minion wordt aangevallen en heeft < 0 levens dus wordt van veld verwijderd.
//
//    }
//
////    @Test
////    public void name() {
////
////        System.out.println(testField.minionAttack(player.drawMinionCard()));
////        System.out.println(testField);
////
////        testField.increment();
////        testField.getCurMana();
////    }
//
////        System.out.println(testField.minionAttack(player.drawMinionCard()));
////        System.out.println(testField);
////
////        testField.increment();
////        testField.getMana();
////    }
//
//    @Test
//    public void checkIfItsYourTurn() {
//        assertEquals(1,testField.getCurMana());
//        for (int i = 0; i < 4; i++) {
//            testField.increment();
//            //opponent speelt
//            testField.increment();
//            //turn 2-5
//        }
//        assertEquals(5,testField.getCurMana());
//    }
//
//    @Test
//    public void heroStartGame() {
//        assertEquals(30, player.getHero().getLifePoints());
//        assertEquals(0, player.getHero().getAmourPoints());
//    }
//
//    @Test
//    public void heroGetsAmour() {
////        player.getHero().setAmourPoints(5);
//        assertEquals(5, player.getHero().getAmourPoints());
//    }
//
//
//}
