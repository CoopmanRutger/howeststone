package CLI;

import cardCollection.Cards;
import cardCollection.Deck;
import cards.CardMinion;
import heroes.Hero;
import heroes.HeroPower;
import playField.PlayingField;
import player.Player;

import java.util.Random;

public class CLI {
    private Random r = new Random();

    public static void main(String[] args) {
        new CLI().run();
    }

    private void run() {

        Deck deck = new Deck();
        Cards cards = new Cards();

        for (int i = 0; i < 30; i++) {
            deck.addCard(new CardMinion("ID" + i, "0", "name", 0, "type", "heroType", "0", 0, 0, "black", "lol"));
            cards.addCard(new CardMinion("ID" + i, "0", "name", 0, "type", "heroType", "0", 0, 0, "black", "lol"));
        }

//        System.out.println(cards);

        HeroPower heroPower = new HeroPower(0, 0, true);
        Hero hero = new Hero("hero", "im", heroPower);

        Player p = new Player(deck,hero);
        Player o = new Player(deck,hero);

        boolean begins = r.nextInt(2)==0;

        PlayingField pf = new PlayingField(p,o,begins);

//        System.out.println(pf);

//        while (true) {
//            System.out.println(pf);
//            if (!pf.getCurrentPlayer().isAlive()){
//                break;
//            }
//            pf.incerement();
//        }
    }
}
