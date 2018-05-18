package CLI;

import cardCollection.Cards;
import cardCollection.Deck;
import cards.Card;
import cards.CardMinion;
import heroes.Hero;
import heroes.HeroPower;
import playField.PlayingField;
import player.Player;

import java.util.Random;
import java.util.Scanner;

public class CLI {

    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new CLI().init();
    }

    private void init(){
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
        String out;
        if (pf.isOpponent())
            out = "you won";
        else
            out = "you lost";

        System.out.println(out);
    }

    private void playerMechanics(PlayingField pf) {
        boolean committed = false;

        System.out.println("Your turn!");

        while (!committed){
            System.out.print("$ ");

            String command = input.next();

            switch (command) {
                case "attack":
                    System.out.print("Give id of attacking card: ");
                    String idP = input.next();
                    System.out.print("Give id of attacked card: ");
                    String idO = input.next();

                    CardMinion playerCard = (CardMinion) pf.getCardsOnFieldPlayer().findById(idP);
                    CardMinion opponentCard = (CardMinion) pf.getCardsOnFieldOpponent().findById(idO);

                    int damage = playerCard.getAttack();

                    opponentCard.takeDamage(damage);

                    if (!opponentCard.isAlive()){
                        pf.getCardsOnFieldOpponent().remove(idO);
                    }

                    break;
                case "pc":
                case "playCard":
                    System.out.print("Give id of card to play: ");
                    String id = input.next();
                    pf.playCard(id);
                    break;
                case "scih":
                case "showCardsInHand":
                    System.out.println(pf.getCurrentPlayer().getCardsInHand());
                    break;
                case "scof":
                case "showCardsOnField":
                    System.out.println("Opponent's cards:");
                    System.out.println(pf.getCardsOnFieldOpponent());
                    System.out.println("Your cards:");
                    System.out.println(pf.getCardsOnFieldPlayer());
                    break;
                case "gm":
                case "getMana":
                    System.out.println(pf.getMana());
                    break;
                case "commit":
                    committed = true;
                    break;
                default:
                    System.out.println("Invalid command!");
                    System.out.println("Valid commands are:");
                    System.out.println("playCard, showCardsInHand, showCardsOnField, getMana, commit");
                    break;
            }
        }
        pf.getCurrentPlayer().drawCard();
    }

    private void botMechanics(PlayingField pf) {
        System.out.println("Opponent's turn!");

//        Cards playable = pf.getCurrentPlayer().getCardsInHand();
//
//        boolean running = true;
//        boolean stop;
//
//        while (running) {
//            stop = true;
//            for (Card card : playable.getCards()) {
//                if (card.getMana() <= pf.getMana()) {
//                    pf.playCard(card.getCardId());
//                    stop = false;
//                }
//            }
//            if (stop) running = false;
//        }
    }
}
