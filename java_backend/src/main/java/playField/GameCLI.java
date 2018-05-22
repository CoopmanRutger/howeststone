package playField;

import cardCollection.Cards;
import cards.Card;
import cards.CardMinion;
import heroes.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class GameCLI extends Game {
    protected Scanner input;

    protected boolean committed = false;

    public GameCLI() {
        super();
        input = new Scanner(System.in);
    }

    protected void playerMechanics() {
        committed = false;

        System.out.println("Your turn!");

        while (!committed){
            System.out.print("$ ");

            String command = input.next();

            switch (command) {
                case "ac":
                case "attackCard":
                    attackCardCLI();
                    break;
                case "ah":
                case "attackHero":
                    attackHeroCLI();
                    break;
                case "pc":
                case "playCard":
                    playCardCLI();
                    break;
                case "scih":
                case "showCardsInHand":
                    showCardsInHandCLI();
                    break;
                case "scof":
                case "showCardsOnField":
                    showCardsOnFieldCLI();
                    break;
                case "sh":
                case "showHeroes":
                    showHeroesCLI();
                    break;
                case "gm":
                case "getCurMana":
                    getCurManaCLI();
                    break;
                case "c":
                case "commit":
                    commit();
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

    protected void botMechanics() {
        System.out.println("Opponent's turn!");

        // GETTING PLAYABLE CARDS

        Cards playable = pf.getOpponent().getCardsInHand();

        boolean running = true;
        boolean played;
        List<Card> toRemove;

        while (running) {
            played = false;


            // GETTING CARDS TO PLAY

            toRemove = new ArrayList<>();
            for (Card card : playable.getCards()) {
                if (card.getMana() <= pf.getCurMana()) {
                    played = true;
                    toRemove.add(card);
                }
            }

            // PLAYING CARDS TO PLAY

            for (Card card : toRemove) pf.playCard(card.getCardId());
            if (!played) running = false;
        }

        // ATTACKING IF POSSIBLE

        // GETTING CARDS TO ATTACK

        Cards toAttack = pf.getOpponent().getCardsOnField();
        int damage;

        // ATTACKING

        for (Card card : toAttack.getCards()) {
            damage = card.getAttack();
            pf.getPlayer().getHero().takeDamage(damage);
        }

        // DRAWING NEW CARD

        pf.getOpponent().drawCard();
    }

    protected void endGame(){
        String out;

        System.out.println("Player is alive? " + pf.getPlayer().isAlive());
        System.out.println("Opponent is alive? " + pf.getOpponent().isAlive());

        if (pf.getPlayer().isAlive())
            out = "you won";
        else if (pf.getOpponent().isAlive()) {
            out = "you lost";
        } else {
            out = "somting wong";
        }

        System.out.println(out);
    };

    protected abstract void showCardsOnFieldCLI();

    protected abstract void getCurManaCLI();

    protected abstract void showHeroesCLI();

    protected abstract void showCardsInHandCLI();

    protected abstract void playCardCLI();

    protected abstract void attackHeroCLI();

    protected abstract void attackCardCLI();
}
