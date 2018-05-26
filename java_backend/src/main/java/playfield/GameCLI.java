package playfield;

import playfield.cardCollection.Cards;
import playfield.cardCollection.cards.Card;
import playfield.cardCollection.cards.CardMinion;
import playfield.cardCollection.cards.additionalCardMechanics.Conditions;
import playfield.player.heroes.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//return null;
//@Override
//}
//return possibleHit2;
//else if (possibleHit2 != null){
//}
//return possibleHit1;
//if (possibleHit1 != null) {
//CardMinion actualCard = null;
//CardMinion possibleHit2 = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(id);
//CardMinion possibleHit1 = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(id);
//String id = input.next();
//System.out.print("give ID of minion to affect: ");
//public ArrayList<CardMinion> specificMinion(){
//@Override
//}
//return cards1AndCards2Combined;
//cards1AndCards2Combined.addAll(cards2);
//cards1AndCards2Combined.addAll(cards1);
//ArrayList<CardMinion> cards1AndCards2Combined = new ArrayList<>();
//ArrayList<CardMinion> cards2 = (ArrayList<CardMinion>) pf.getCurrentPlayer().getCardsOnField();
//ArrayList<CardMinion> cards1 = (ArrayList<CardMinion>) pf.getOppositePlayer().getCardsOnField();
//System.out.print("All minions will be affected");
//public ArrayList<CardMinion> allMinions(){
//@Override
//}
//return cards;
//ArrayList<CardMinion> cards = (ArrayList<CardMinion>) pf.getOppositePlayer().getCardsOnField();
//System.out.print("All enemy minions will be affected.");
//public ArrayList<CardMinion> allMinionsEnemy(){
//@Override
//}
//return cards;
//ArrayList<CardMinion> cards = (ArrayList<CardMinion>) pf.getCurrentPlayer().getCardsOnField();
//System.out.print("All friendly minions will be affected.");
//public ArrayList<CardMinion> allMinionsFriendly(){

public abstract class GameCLI extends Conditions {
    protected Scanner input;
    protected boolean committed;

    GameCLI() {
        super();
        input = new Scanner(System.in);
        committed = false;
    }

    private void printFullLine() {
        System.out.println("####################");
    }
    private void printHalfLine() {
        System.out.println("#                  #");
    }

    public void playerMechanics() {
        committed = false;

        printFullLine();
        printHalfLine();
        System.out.println("#    Your turn!    #");
        printHalfLine();
        printFullLine();

        while (!committed) {
            System.out.print("$ ");

            final String command = input.next();

            switch (command) {
                case "ac":
                case "attackCard":
                    attackCardCLI();
                    break;
                case "ah":
                case "attackHero":
                    attackHeroCLI();
                    break;
                case "sw":
                case "showWeapon":
                    showWeapon();
                    break;
                case "pw":
                case "playWeapon":
                    attackWithWeapon();
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
                case "php":
                case "playHeroPower":
                    playHeroPower();
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

    protected abstract void showWeapon();

    public void botMechanics() {
        printFullLine();
        printHalfLine();
        System.out.println("#    Opponent's turn!    #");
        printHalfLine();
        printFullLine();

        // GETTING PLAYABLE CARDS

        final Cards playable = pf.getOpponent().getCardsInHand();

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

            for (Card card : toRemove) {
                playCard(card.getCardId());
            }
            //for (Card card : toRemove) playCard(card.getCardId());
            if (!played) {
                running = false;
            }
        }

        // ATTACKING IF POSSIBLE

        // GETTING CARDS TO ATTACK

        final Cards toAttack = pf.getOpponent().getCardsOnField();
        final int damage;

        // ATTACKING

        for (Card card : toAttack.getCards()) {
            attackHero(card.getCardId());
        }

        // DRAWING NEW CARD

        pf.getOpponent().drawCard();
    }

    public void endGame() {
        String out = "\n";

        if (pf.getPlayer().isAlive()) {
            out = "you won";
        } else if (pf.getOpponent().isAlive()) {
            out = "you lost";
        } else {
            out = "somting wong";
        }
    }

    protected abstract void showCardsOnFieldCLI();

    protected abstract void getCurManaCLI();

    protected abstract void showHeroesCLI();

    protected abstract void showCardsInHandCLI();

    protected abstract void playCardCLI();

    protected abstract void attackHeroCLI();

    protected abstract void attackCardCLI();

    // TARGET FUNCTIONS

    private void giveIdOfCardToAffect() {
        System.out.print("Give id of card to affect: ");
    }

    @Override
    public CardMinion specificMinionEnemy() {
        giveIdOfCardToAffect();
        final String id = input.next();
        final CardMinion card = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(id);
        return card;
    }

    @Override
    public CardMinion specificMinionFriendly() {
        giveIdOfCardToAffect();
        final String id = input.next();
        final CardMinion card = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(id);
        return card;
    }

    @Override
    public Hero playerHero() {
        System.out.println("Your own hero will be affected.");
        final Hero ownhero = (Hero) pf.getCurrentPlayer().getHero();
        return ownhero;
    }

    @Override
    public Hero enemyHero() {
        System.out.print("The enemy hero will be affected.");
        final Hero opphero = (Hero) pf.getOppositePlayer().getHero();
        return opphero;
    }

    @Override
    public Object specificCharacterFriendly() {
        System.out.print("Do you want to target your Hero or one of your minions (1 for hero, 2 for minion): ");
        final int choice = input.nextInt();
        Object out = null;
        //Hero ownhero = (Hero) pf.getCurrentPlayer().getHero();
        if (choice == 1) {
            out = playerHero();
        } else if (choice == 2) {
            final String id = input.next();
            final CardMinion card = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(id);
            out = card;
        }
        return out;
        // if choice was not one of the above, could have implemented way to reiterate question,
        // but then again, time issues
    }

    @Override
    public Object specificCharacterEnemy() {
        System.out.print("Do you want to target their Hero or one of their minions (1 for hero, 2 for minion): ");
        final int choice = input.nextInt();
        Object out = null;
        //Hero ownhero = (Hero) pf.getCurrentPlayer().getHero();
        if (choice == 1) {
            out = enemyHero();
        } else if (choice == 2) {
            System.out.print("give id of card to affect: ");
            final String id = input.next();
            final CardMinion card = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(id);
            out = card;
        }
        return out;
        // if choice was not one of the above, could have implemented way to reiterate question,
        // but then again, time issues
    }
}
