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
        new CLI().run();
    }

    private CLI() {
        super();
    }

    @Override
    protected void showCardsOnFieldCLI() {
        System.out.println("Opponent's cards:");
        System.out.println(pf.getOpponent().getCardsOnField());
        System.out.println("Your cards:");
        System.out.println(pf.getPlayer().getCardsOnField());
    }

    @Override
    protected void commit() {
        committed = true;
    }

    @Override
    protected void getCurManaCLI() {
        System.out.println(pf.getCurMana());
    }

    @Override
    protected void showHeroesCLI() {
        System.out.println("Opponent's Hero:");
        System.out.println(pf.getOpponent().getHero());
        System.out.println("Your Hero:");
        System.out.println(pf.getPlayer().getHero());
    }

    @Override
    protected void showCardsInHandCLI() {
        System.out.println(pf.getCurrentPlayer().getCardsInHand());
    }

    @Override
    protected void playCardCLI() {
        System.out.print("Give id of card to play: ");
        String id = input.next();
        playCard(id);
    }

    @Override
    protected void attackHeroCLI() {
        System.out.print("Give id of attacking card: ");
        String pId = input.next();
        attackHero(pId);
    }

    @Override
    protected void attackCardCLI() {
        System.out.print("Give id of attacking card: ");
        String idP = input.next();
        System.out.print("Give id of attacked card: ");
        String idO = input.next();
    }
}
