package playField;

import cardCollection.Cards;
import cardCollection.Deck;
import cards.Card;
import cards.CardMinion;
import heroes.Hero;
import heroes.HeroPower;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game {
    protected Scanner input = new Scanner(System.in);

    public Game(){
        Deck deck = new Deck();

        for (int i = 0; i < 30; i++) {
            deck.addCard(new CardMinion("ID" + i, "0", "name", i/6 + 1, "type", "heroType", "0", 0, 0, "race", "mechanics"));
        }

        HeroPower heroPower = new HeroPower("", 0, "","",1,1,"",true);
        Hero hero = new Hero("hero", "im", heroPower);

        Player p = new Player(deck, hero);
        Player o = new Player(deck, hero);

        PlayingField pf = new PlayingField(p,o);
        run(pf);
    }

    private void run(PlayingField pf) {
        while (true) {
            if (pf.isOpponent()) botMechanics(pf);
            else playerMechanics(pf);

            if (!pf.getCurrentPlayer().isAlive()) break;
            pf.increment();
        }
        endGame(pf);
    }

    protected void endGame(PlayingField pf){
        String out;
        if (pf.isOpponent())
            out = "you won";
        else
            out = "you lost";

        System.out.println(out);
    };

    protected abstract void botMechanics(PlayingField pf);

    protected abstract void playerMechanics(PlayingField pf);
}
