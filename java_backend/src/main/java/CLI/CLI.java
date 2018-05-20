package CLI;

import cardCollection.Cards;
import cards.Card;
import cards.CardMinion;
import heroes.Hero;
import playField.GameCLI;
import playField.PlayingField;

import java.util.ArrayList;
import java.util.List;

public class CLI extends GameCLI {
    public static void main(String[] args) {
        new CLI();
    }

    private CLI() {
        super();
    }

    @Override
    protected void showCardsOnField(PlayingField pf) {
        System.out.println("Opponent's cards:");
        System.out.println(pf.getOpponent().getCardsOnField());
        System.out.println("Your cards:");
        System.out.println(pf.getPlayer().getCardsOnField());
    }

    @Override
    protected void commit(PlayingField pf) {
        committed = true;
    }

    @Override
    protected void getCurMana(PlayingField pf) {
        System.out.println(pf.getCurMana());
    }

    @Override
    protected void showHeroes(PlayingField pf) {
        System.out.println("Opponent's Hero:");
        System.out.println(pf.getOpponent().getHero());
        System.out.println("Your Hero:");
        System.out.println(pf.getPlayer().getHero());
    }

    @Override
    protected void showCardsInHand(PlayingField pf) {
        System.out.println(pf.getCurrentPlayer().getCardsInHand());
    }

    @Override
    protected void playCard(PlayingField pf) {
        System.out.print("Give id of card to play: ");
        String id = input.next();
        pf.playCard(id);
    }

    @Override
    protected void attackHero(PlayingField pf) {
        System.out.print("Give id of attacking card: ");
        String idP = input.next();

        CardMinion playerCard = (CardMinion) pf.getPlayer().getCardsOnField().findById(idP);
        Hero hero = pf.getOpponent().getHero();

        int damage = playerCard.getAttack();

        hero.takeDamage(damage);

        if (!hero.isAlive()){
            endGame(pf);
        }
    }

    @Override
    protected void attackCard(PlayingField pf) {
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
    }

    protected void botMechanics(PlayingField pf) {
        System.out.println("Opponent's turn!");

        Cards playable = pf.getOpponent().getCardsInHand();

        boolean running = true;
        boolean played;
        List<Card> toRemove;

        while (running) {
            played = false;
            toRemove = new ArrayList<>();
            for (Card card : playable.getCards()) {
                if (card.getMana() <= pf.getCurMana()) {
                    played = true;
                    toRemove.add(card);
                }
            }
            for (Card card : toRemove) pf.playCard(card.getCardId());
            if (!played) running = false;
        }
        pf.getOpponent().drawCard();
    }
}
