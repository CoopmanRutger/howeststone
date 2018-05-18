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

                    CardMinion playerCard = (CardMinion) pf.getPlayer().getCardsOnField().findById(idP);
                    CardMinion opponentCard = (CardMinion) pf.getOpponent().getCardsOnField().findById(idO);

                    int damage = playerCard.getAttack();

                    opponentCard.takeDamage(damage);

                    if (!opponentCard.isAlive()){
                        pf.getOpponent().getCardsOnField().remove(idO);
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
                    System.out.println(pf.getOpponent().getCardsOnField());
                    System.out.println("Your cards:");
                    System.out.println(pf.getPlayer().getCardsOnField());
                    break;
                case "gm":
                case "getMana":
                    System.out.println(pf.getMana());
                    break;
                case "c":
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
        pf.getPlayer().drawCard();
    }

    private void botMechanics(PlayingField pf) {
        System.out.println("Opponent's turn!");

        Cards playable = pf.getOpponent().getCardsInHand();

        System.out.println(playable);

        boolean running = true;
        boolean played;

        while (running) {
            played = false;
            for (Card card : playable.getCards()) {
                System.out.println(pf.getMana());
                if (card.getMana() <= pf.getMana()) {
                    played = true;
                    pf.playCard(card.getCardId());
                }
            }
            System.out.println(played);
            if (!played) {
                running = false;
            }
        }
    }
}
