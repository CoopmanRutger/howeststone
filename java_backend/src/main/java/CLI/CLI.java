package CLI;

import cardCollection.Cards;
import cardCollection.Deck;
import cards.CardMinion;
import heroes.Hero;
import heroes.HeroPower;
import playField.PlayingField;
import player.Player;

import java.util.Random;
import java.util.Scanner;

public class CLI {
    private Random r = new Random();
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new CLI().init();
    }

    private void init(){
        Deck deck = new Deck();

        for (int i = 0; i < 30; i++) {
            deck.addCard(new CardMinion("ID" + i, "0", "name", 0, "type", "heroType", "0", 0, 0, "black", "lol"));
        }

        HeroPower heroPower = new HeroPower(0, 0, true);
        Hero hero = new Hero("hero", "im", heroPower);

        Player p = new Player(deck, hero);
        Player o = new Player(deck, hero);

        boolean begins = r.nextInt(2) == 0;

        PlayingField pf = new PlayingField(p,o,begins);
        run(pf);
    }

    private void run(PlayingField pf) {
        while (true) {
            if (pf.isOpponent())
                botMechanics(pf);
            else
                playerMechanics(pf);

            if (!pf.getCurrentPlayer().isAlive()){
                break;
            }
            pf.increment();
        }
        String out;
        if (pf.isOpponent())
            out = "you won";
        else
            out = "you lost";

        System.out.println(out);
    }

    private void playerMechanics(PlayingField pf) {
        System.out.println(pf);
        System.out.print("$");
        System.out.println(input.next());
        // game mechanics
    }

    private void botMechanics(PlayingField pf) {
    }
}
