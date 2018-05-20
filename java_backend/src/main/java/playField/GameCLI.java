package playField;

import cardCollection.Cards;
import cards.Card;
import cards.CardMinion;
import heroes.Hero;

import java.util.ArrayList;
import java.util.List;

public abstract class GameCLI extends Game {
    protected boolean committed = false;
    public GameCLI() {
        super();
    }

    protected void playerMechanics(PlayingField pf) {
        committed = false;

        System.out.println("Your turn!");

        while (!committed){
            System.out.print("$ ");

            String command = input.next();

            switch (command) {
                case "ac":
                case "attackCard":
                    attackCard(pf);
                    break;
                case "ah":
                case "attackHero":
                    attackHero(pf);
                    break;
                case "pc":
                case "playCard":
                    playCard(pf);
                    break;
                case "scih":
                case "showCardsInHand":
                    showCardsInHand(pf);
                    break;
                case "scof":
                case "showCardsOnField":
                    showCardsOnField(pf);
                    break;
                case "sh":
                case "showHeroes":
                    showHeroes(pf);
                    break;
                case "gm":
                case "getCurMana":
                    getCurMana(pf);
                    break;
                case "c":
                case "commit":
                    commit(pf);
                    break;
                default:
                    System.out.println("Invalid command!");
                    System.out.println("Valid commands are:");
                    System.out.println("playCard, showCardsInHand, showCardsOnField, getCurMana, commit");
                    break;
            }
        }
        pf.getPlayer().drawCard();
    }

    protected void endGame(PlayingField pf){
        String out;
        if (pf.isOpponent())
            out = "you won";
        else
            out = "you lost";

        System.out.println(out);
    };

    protected abstract void showCardsOnField(PlayingField pf);

    protected abstract void commit(PlayingField pf);

    protected abstract void getCurMana(PlayingField pf);

    protected abstract void showHeroes(PlayingField pf);

    protected abstract void showCardsInHand(PlayingField pf);

    protected abstract void playCard(PlayingField pf);

    protected abstract void attackHero(PlayingField pf);

    protected abstract void attackCard(PlayingField pf);

}
