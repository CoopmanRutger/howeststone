package playField;

import playField.cardCollection.Deck;
import playField.cardCollection.cards.Card;
import playField.cardCollection.cards.CardMinion;
import playField.cardCollection.cards.CardMinionAbility;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;
import playField.player.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static playField.cardCollection.cards.CardMinionAbility.*;

public abstract class Game {
    protected PlayingField pf;

    public Game(){
        Set<CardMinionAbility> tempSet;

        Deck playerDeck = new Deck();
        Deck opponentDeck = new Deck();

        for (int i = 0; i < 30; i++) {
            tempSet = new HashSet<>();
            tempSet.add(charge);
            playerDeck.addCard(new CardMinion("ID" + i, "name" + i, "type", i/6 + 1, "type", "heroType", "img", i/5 + 1, (i+1)/5 + 1, "race", "mechanics", tempSet));

            tempSet = new HashSet<>();
            tempSet.add(divineShield);
            opponentDeck.addCard(new CardMinion("ID" + i, "name" + i, "type", i/6 + 1, "type", "heroType", "img", i/5 + 1, (i+1)/5 + 1, "race", "mechanics", tempSet));
        }

        HeroPower playerHeroPower = new HeroPower("", 0, "","",1,1,"",true);
        HeroPower opponentHeroPower = new HeroPower("", 0, "","",1,1,"",true);
        Hero playerHero = new Hero("heroPlayer", "im", playerHeroPower);
        Hero opponentHero = new Hero("heroOpponent", "im", opponentHeroPower);

        Player p = new Player(playerDeck, playerHero);
        Player o = new Player(opponentDeck, opponentHero);

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
            ((CardMinion) card).resetCanAttack(true);
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
        CardMinion playerCard = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(pId);
        CardMinion opponentCard = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(oId);

        int damage;

        if (playerCard != null && opponentCard != null && playerCard.getCanAttack()) {
            damage = playerCard.getAttack();
            opponentCard.takeDamage(damage);

            damage = opponentCard.getAttack();
            playerCard.takeDamage(damage);

            playerCard.incrCanAttack(false);

            if (!opponentCard.isAlive()) pf.getOpponent().getCardsOnField().remove(oId);
        }
    }

    protected void attackHero(String pId) {
        CardMinion playerCard = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(pId);
        Hero hero = pf.getOppositePlayer().getHero();

        if (playerCard != null && hero != null && playerCard.getCanAttack()) {
            int damage = playerCard.getAttack();

            hero.takeDamage(damage);

            playerCard.incrCanAttack(false);

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
