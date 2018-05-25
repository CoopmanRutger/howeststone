package playField;

import playField.cardCollection.Cards;
import playField.cardCollection.cards.Card;
import playField.cardCollection.cards.CardMinion;
import playField.cardCollection.cards.additionalCardMechanics.Conditions;
import playField.player.heroes.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class GameCLI extends Conditions {
    protected Scanner input;

    protected boolean committed = false;

    public GameCLI() {
        super();
        input = new Scanner(System.in);
    }

    public void playerMechanics() {
        committed = false;

        System.out.println("####################");
        System.out.println("#                  #");
        System.out.println("#    Your turn!    #");
        System.out.println("#                  #");
        System.out.println("####################");

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
        System.out.println("##########################");
        System.out.println("#                        #");
        System.out.println("#    Opponent's turn!    #");
        System.out.println("#                        #");
        System.out.println("##########################");

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

            for (Card card : toRemove) playCard(card.getCardId());
//            for (Card card : toRemove) playCard(card.getCardId());
            if (!played) running = false;
        }

        // ATTACKING IF POSSIBLE

        // GETTING CARDS TO ATTACK

        Cards toAttack = pf.getOpponent().getCardsOnField();
        int damage;

        // ATTACKING

        for (Card card : toAttack.getCards()) {
            attackHero(card.getCardId());
        }

        // DRAWING NEW CARD

        pf.getOpponent().drawCard();
    }

    public void endGame(){
        String out = "\n";

        if (pf.getPlayer().isAlive()) out = "you won";
        else if (pf.getOpponent().isAlive()) out = "you lost";
        else out = "somting wong";

        System.out.println(out);
    };

    protected abstract void showCardsOnFieldCLI();

    protected abstract void getCurManaCLI();

    protected abstract void showHeroesCLI();

    protected abstract void showCardsInHandCLI();

    protected abstract void playCardCLI();

    protected abstract void attackHeroCLI();

    protected abstract void attackCardCLI();

    // TARGET FUNCTIONS


    @Override
    public CardMinion specificMinionEnemy() {
        System.out.print("Give id of card to affect: ");
        String id = input.next();
        CardMinion card = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(id);
        return card;
    }
    @Override
    public CardMinion specificMinionFriendly(){
        System.out.print("Give id of card to affect: ");
        String id = input.next();
        CardMinion card = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(id);
        return card;
    }
    @Override
    public Hero playerHero(){
        System.out.println("Your own hero will be affected.");
        Hero ownhero = (Hero) pf.getCurrentPlayer().getHero();
        return ownhero;
    }
    @Override
    public Hero enemyHero(){
        System.out.print("The enemy hero will be affected.");
        Hero opphero = (Hero) pf.getOppositePlayer().getHero();
        return opphero;
    }
    @Override
    public Object specificCharacterFriendly(){
        System.out.print("Do you want to target your Hero or one of your minions (1 for hero, 2 for minion): ");
        int choice = input.nextInt();
//        Hero ownhero = (Hero) pf.getCurrentPlayer().getHero();
        if (choice == 1){
            return playerHero();
        } else if (choice == 2) {
            String id = input.next();
            CardMinion card = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(id);
            return card;
        }
        return null;
        // if choice was not one of the above, could have implemented way to reiterate question, but then again, time issues
    }
    @Override
    public Object specificCharacterEnemy(){
        System.out.print("Do you want to target their Hero or one of their minions (1 for hero, 2 for minion): ");
        int choice = input.nextInt();
//        Hero ownhero = (Hero) pf.getCurrentPlayer().getHero();
        if (choice == 1){
            return enemyHero();
        } else if (choice == 2) {
            System.out.print("give id of card to affect: ");
            String id = input.next();
            CardMinion card = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(id);
            return card;
        }
        return null;
        // if choice was not one of the above, could have implemented way to reiterate question, but then again, time issues
    }
    @Override
    public ArrayList<CardMinion> allMinionsFriendly(){
        System.out.print("All friendly minions will be affected.");
        ArrayList<CardMinion> cards = (ArrayList<CardMinion>) pf.getCurrentPlayer().getCardsOnField();
        return cards;
    }
    @Override
    public ArrayList<CardMinion> allMinionsEnemy(){
        System.out.print("All enemy minions will be affected.");
        ArrayList<CardMinion> cards = (ArrayList<CardMinion>) pf.getOppositePlayer().getCardsOnField();
        return cards;
    }
    @Override
    public ArrayList<CardMinion> allMinions(){
        System.out.print("All minions will be affected");
        ArrayList<CardMinion> cards1 = (ArrayList<CardMinion>) pf.getOppositePlayer().getCardsOnField();
        ArrayList<CardMinion> cards2 = (ArrayList<CardMinion>) pf.getCurrentPlayer().getCardsOnField();
        ArrayList<CardMinion> cards1AndCards2Combined = new ArrayList<>();
        cards1AndCards2Combined.addAll(cards1);
        cards1AndCards2Combined.addAll(cards2);
        return cards1AndCards2Combined;
    }
    @Override
    public ArrayList<CardMinion> specificMinion(){
        System.out.print("give ID of minion to affect: ");
        String id = input.next();
        CardMinion possibleHit1 = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(id);
        CardMinion possibleHit2 = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(id);
        CardMinion actualCard = null;
        if (possibleHit1 != null) {
            return possibleHit1;
        }
        else if (possibleHit2 != null){
            return possibleHit2;
        }
        return null;
     }
     @Override
    public



}
