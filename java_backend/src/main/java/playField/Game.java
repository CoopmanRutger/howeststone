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
import java.util.Set;

public abstract class Game {
    protected PlayingField pf;

    public Game(){
        Deck deck = new Deck();

        for (int i = 0; i < 30; i++) {
            deck.addCard(new CardMinion("ID" + i, "name" + i, "type", i/6 + 1, "type", "heroType", "img", i/5 + 1, (i+1)/5 + 1, "race", "mechanics"));
        }

        HeroPower playerHeroPower = new HeroPower("", 0, "","",1,1,"",true);
        HeroPower opponentHeroPower = new HeroPower("", 0, "","",1,1,"",true);
        Hero playerHero = new Hero("hero", "im", playerHeroPower);
        Hero opponentHero = new Hero("hero", "im", opponentHeroPower);

        Player p = new Player(deck, playerHero);
        Player o = new Player(deck, opponentHero);

        pf = new PlayingField(p,o);
    }

    protected void run() {
        while (true) {
            updateCanAttack();

            if (pf.isOpponent()) botMechanics();
            else playerMechanics();

            if (!pf.getPlayer().isAlive() || !pf.getOpponent().isAlive()) break;

            pf.increment();
        }
        endGame();
    }

    private void updateCanAttack() {
        List<Card> cards = pf.getCurrentPlayer().getCardsOnField().getCards();
        for (Card card : cards) {
            CardMinion newCard = (CardMinion) card;
            newCard.setCanAttack(true);
        }
    }

    protected void endGame(){
        String out;
        if (pf.isOpponent())
            out = "you won";
        else
            out = "you lost";

        System.out.println(out);
    };

    protected abstract void botMechanics();

    protected abstract void playerMechanics();

    protected abstract void commit();

    // POSSIBLE ACTIONS

    protected void playCard(String pId) {
        pf.playCard(pId);
    }

    protected void attackCard(String pId, String oId) {
        CardMinion playerCard = (CardMinion) pf.getPlayer().getCardsOnField().findById(pId);
        CardMinion opponentCard = (CardMinion) pf.getOpponent().getCardsOnField().findById(oId);

        if (playerCard.getCanAttack()) {
            int damage = playerCard.getAttack();

            opponentCard.takeDamage(damage);

            if (!opponentCard.isAlive()) pf.getOpponent().getCardsOnField().remove(oId);
        }
    }

    protected void attackHero(String pId) {
        CardMinion playerCard = (CardMinion) pf.getPlayer().getCardsOnField().findById(pId);

        if (playerCard.getCanAttack()) {
            int damage = playerCard.getAttack();

            Hero hero = pf.getOpponent().getHero();
            hero.takeDamage(damage);

            if (!hero.isAlive()) commit();
        }
    }

    // TO IMPLEMENT:

    protected void playHeroPower() {

    }

    protected void playWeaponOnCard() {

    }

    protected void playWeaponOnHero() {

    }
}
