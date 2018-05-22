package playField;

import playField.cardCollection.Deck;
import playField.cardCollection.cards.Card;
import playField.cardCollection.cards.CardMinion;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;
import playField.player.Player;

import java.util.List;

public abstract class Game {
    protected PlayingField pf;

    public Game(){
        Deck deck = new Deck();

        for (int i = 0; i < 30; i++) {
            deck.addCard(new CardMinion("ID" + i, "name" + i, "type", i/6 + 1, "type", "heroType", "img", i/5 + 1, (i+1)/5 + 1, "race", "mechanics"));
        }

        HeroPower playerHeroPower = new HeroPower("", 0, "","",1,1,"",true);
        HeroPower opponentHeroPower = new HeroPower("", 0, "","",1,1,"",true);
        Hero playerHero = new Hero("heroPlayer", "im", playerHeroPower);
        Hero opponentHero = new Hero("heroOpponent", "im", opponentHeroPower);

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
            ((CardMinion) card).setCanAttack(true);
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

        if (playerCard != null && opponentCard != null && playerCard.getCanAttack()) {
            int damage = playerCard.getAttack();

            opponentCard.takeDamage(damage);

            playerCard.setCanAttack(false);

            if (!opponentCard.isAlive()) pf.getOpponent().getCardsOnField().remove(oId);
        }
    }

    protected void attackHero(String pId) {
        CardMinion playerCard = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(pId);
        Hero hero = pf.getOppositePlayer().getHero();

        if (playerCard != null && hero != null && playerCard.getCanAttack()) {
            int damage = playerCard.getAttack();

            hero.takeDamage(damage);

            playerCard.setCanAttack(false);

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
