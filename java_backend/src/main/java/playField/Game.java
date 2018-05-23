package playField;

import playField.cardCollection.Deck;
import playField.cardCollection.cards.Card;
import playField.cardCollection.cards.CardMinion;
import playField.cardCollection.cards.CardMinionAbility;
import playField.player.heroes.AbilityType;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;
import playField.player.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static playField.cardCollection.cards.CardMinionAbility.*;
import static playField.player.heroes.AbilityType.attack;
import static playField.player.heroes.AbilityType.heal;

public abstract class Game {

    protected PlayingField pf;

    // CONTRUCTOR

    public Game(Deck playerDeck,
                Deck opponentDeck,
                Hero playerHero,
                Hero opponentHero){

        pf = new PlayingField(new Player(playerDeck, playerHero), new Player(opponentDeck, opponentHero));
    }

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

        HeroPower playerHeroPower = new HeroPower("", 0, "", heal,1,1,"",true);
        HeroPower opponentHeroPower = new HeroPower("", 0, "", attack,1,1,"",true);
        Hero playerHero = new Hero("heroPlayer", "im", playerHeroPower);
        Hero opponentHero = new Hero("heroOpponent", "im", opponentHeroPower);

        Player p = new Player(playerDeck, playerHero);
        Player o = new Player(opponentDeck, opponentHero);

        pf = new PlayingField(new Player(playerDeck, playerHero), new Player(opponentDeck, opponentHero));
    }

    public void run() {
        while (true) {
            updateCanAttack();

            if (pf.isOpponent()) botMechanics();
            else playerMechanics();

            if (!pf.getPlayer().isAlive() || !pf.getOpponent().isAlive()) break;

            pf.increment();
        }
        endGame();
    }

    private void updateCanAttack() { // zet de minions op "kan aanvallen"
        List<Card> cards = pf.getCurrentPlayer().getCardsOnField().getCards();
        for (Card card : cards) {
            ((CardMinion) card).resetCanAttack(true);
        }
    }

    protected abstract void endGame();

    protected abstract void botMechanics();

    protected abstract void playerMechanics();

    protected abstract void commit();

    // POSSIBLE ACTIONS

    protected void playCard(String pId) {
        Player curPlayer = pf.getCurrentPlayer();

        Card card = curPlayer.getCardsInHand().findById(pId);
        int mana = curPlayer.getManaFromId(pId);

        System.out.println(card.getType());



        if (card != null && mana <= pf.getCurMana()) {
            String type = card.getType();
            switch (type) {
                case "CardMinion":
                    curPlayer.playCard(pId);
                    break;
            }
        }
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

            if (!playerCard.isAlive()) pf.getCurrentPlayer().getCardsOnField().remove(pId);
            if (!opponentCard.isAlive()) pf.getOppositePlayer().getCardsOnField().remove(oId);
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

    protected void playHeroPower() {
        HeroPower heroPower = pf.getCurrentPlayer().getHero().getHeroPower();

        int mana = heroPower.getManaCost();

        if (mana <= pf.getCurMana()) {
            if (heroPower.getAbilityType() == attack)
                attackHeroPower(heroPower);
            else healHeroPower(heroPower);

            pf.decrMana(mana);
        }
    }

    // TO IMPLEMENT:

    protected abstract void attackHeroPower(HeroPower playerHeroPower);

    protected abstract void healHeroPower(HeroPower playerHeroPower);

    protected void playWeaponOnCard() {

    }

    protected void playWeaponOnHero() {

    }
}
