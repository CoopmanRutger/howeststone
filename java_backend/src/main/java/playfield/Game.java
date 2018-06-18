package playfield;

import playfield.cardCollection.Deck;

import playfield.cardCollection.cards.*;

import playfield.cardCollection.cards.Card;
import playfield.cardCollection.cards.CardMinion;
import playfield.player.PlayableDeck;
import playfield.player.Player;

import playfield.player.heroes.Hero;
import playfield.player.heroes.HeroPower;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static playfield.cardCollection.cards.CardActions.*;
import static playfield.player.heroes.AbilityType.*;


public abstract class Game {

    public PlayingField pf;

    // CONTRUCTOR

    public Game(PlayableDeck playerDeck, PlayableDeck opponentDeck) {

        pf = new PlayingField(new Player(playerDeck), new Player(opponentDeck));
    }

    public Game() {
        HashSet<CardActions> tempSet;
        HashSet<CardAbility> tempSet2;

        final Deck playerDeck = new Deck();
        final Deck opponentDeck = new Deck();

        for (int i = 0; i < 30; i++) {
            tempSet = new HashSet<>();
            //tempSet.add(addHealth);
            playerDeck.addCard(new CardSpell("Id" + i, "naam" + i, "types", 1, "heroType",
                    "description", "http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_015.png",
                    "", tempSet, 2, 1, "1", "3", true,
                     1, true, "", true));

            tempSet2 = new HashSet<>();
            //tempSet.add(divineShield);
            opponentDeck.addCard(new CardMinion("ID" + i, "name" + i, "type", i / 6 + 1,
                    "herotype", "info",
                    "http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_001", i / 5 + 1,
                    (i + 1) / 5 + 1, "race", "mechanics", tempSet2));
        }

        final HeroPower playerHeroPower = new HeroPower("", 0, "", heal, 1,
                1, "", true);
        final HeroPower opponentHeroPower = new HeroPower("", 0, "", attack, 1,
                1, "", true);
        final Hero playerHero = new Hero("heroPlayer", "igm", playerHeroPower);
        final Hero opponentHero = new Hero("heroOpponent", "im", opponentHeroPower);

        final Player p = new Player(playerDeck, playerHero);
        final Player o = new Player(opponentDeck, opponentHero);

        pf = new PlayingField(new Player(playerDeck, playerHero), new Player(opponentDeck, opponentHero));
    }

    public void run() {
        while (!pf.getEnd()) {
            updateCanAttack();

            if (pf.whosTurn()) {
                botMechanics();
            } else {
                playerMechanics();
            }

            if (!pf.getPlayer().isAlive() || !pf.getOpponent().isAlive()) {
                break;
            }

            pf.increment();
        }
        endGame();
    }

    // zet de minions op "kan aanvallen"
    protected void updateCanAttack() {
        final List<Card> cards = pf.getCurrentPlayer().getCardsOnField().getCards();
        for (Card card : cards) {
            ((CardMinion) card).resetCanAttack(true);
        }
    }

    // POSSIBLE ACTIONS
    public void playCard(String pId) {
        final Player curPlayer = pf.getCurrentPlayer();

        final Card card = curPlayer.getCardsInHand().findById(pId);
        final int mana = curPlayer.getManaFromId(pId);

        if (card != null && mana <= pf.getCurMana()) {
            final String type = card.identifier();
            System.out.println("The type of the card with id " + card.getCardId() + " is " + type);
            switch (type) {
                case "CardMinion":
                    curPlayer.playCard(pId);
                    break;
                case "CardSpell":
                    spell(((CardSpell) card).getAbilities(), (CardSpell) card);
                    break;
                case "CardWeapon":
                    playWeapon(card);
                    break;
                default:
                    System.out.println("someting wong");
            }
            curPlayer.getCardsInHand().remove(card);
            pf.decrMana(mana);
        }
    }
    // does spell-action
    public void spell(Set<CardActions> abilities, CardSpell card) {
        if (abilities.contains(drawCard)) {
            pf.getCurrentPlayer().drawCard();
        }
        if (abilities.contains(directAttack)) {
            attackWithWeapon();
        }
        if (abilities.contains(addArmour)) {
            addArmour(card.getArmourToGive());
        }
        if (abilities.contains(addHealth)) {
            addHealth(card.getHealthToGive());
        }
        if (abilities.contains(addAttack)) {
            addAttack(card.getAttackToGive());
        }
        //if (abilities.contains(spellDamage)) spellDamage(card);
    }

    // ABSTRACT SPELS
    // not finished works only on condition
    protected void destroyCard(String pId, String oId) {
        // (when minion is attack is five or less OR minion attack is three or less)
        final CardSpell playerCard = (CardSpell) pf.getCurrentPlayer().getCardsOnField().findById(pId);
        final CardMinion opponentCard = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(oId);
        final int destroyDmge;

        if (playerCard != null && opponentCard != null && playerCard.isDestroy()) {
            //if (opponentCard.getAttack() <= 5) { NOT FINISHED
            destroyDmge = opponentCard.getHealth();
            opponentCard.takeDamage(destroyDmge);
        }
    }

    protected void addArmour(int amount) {
        pf.getCurrentPlayer().getHero().incrArmour(amount);
    }

    public void addHealthHero(int healAmount) {
        pf.getCurrentPlayer().getHero().incrHealth(healAmount);
    }

    public void addHealthCard(int healAmount, String id) {
        final Player curPlayer = pf.getCurrentPlayer();
        final CardMinion card = (CardMinion) curPlayer.getCardsOnField().findById(id);

        if (card != null) {
            card.incrHealth(healAmount);
        }
    }

    // ABSTRACT SPELS

    public abstract void addAttack(int amount);


    // BASIC METHOD'S

    public void attackCard(String pId, String oId) {
        final CardMinion playerCard = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(pId);
        final CardMinion opponentCard = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(oId);

        int damage;

        if (playerCard != null && opponentCard != null) {
            damage = playerCard.getAttack();
            opponentCard.takeDamage(damage);

            damage = opponentCard.getAttack();
            playerCard.takeDamage(damage);

            playerCard.incrCanAttack(false);

            if (!playerCard.isAlive()) {
                pf.getCurrentPlayer().getCardsOnField().remove(pId);
            }
            if (!opponentCard.isAlive()) {
                pf.getOppositePlayer().getCardsOnField().remove(oId);
            }
        }
    }

    public void attackHero(String pId) {
        final CardMinion playerCard = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(pId);
        final Hero hero = pf.getOppositePlayer().getHero();

        if (playerCard != null && playerCard.getCanAttack()) {
            final int damage = playerCard.getAttack();
            hero.takeDamage(damage);
            playerCard.incrCanAttack(false);
        }
    }

    public void playHeroPower() {
        final HeroPower heroPower = pf.getCurrentPlayer().getHero().getHeroPower();

        final int mana = heroPower.getManaCost();

        if (mana <= pf.getCurMana()) {
            if (heroPower.getAbilityType() == attack) {
                attackHeroPower(heroPower);
            } else {
                healHeroPower(heroPower);
            }

            pf.decrMana(mana);
        }
    }

    public void playWeaponOnCard(String oId, int damage) {
        final CardMinion opponentCard = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(oId);

        if (opponentCard != null) {
            opponentCard.takeDamage(damage);
        }
    }

    public void playWeaponOnHero(int damage) {
        final Hero hero = pf.getOppositePlayer().getHero();
        hero.takeDamage(damage);
    }
    
    // TO IMPLEMENT:

    public abstract void addHealth(int healthToGive);

    public abstract void attackHeroPower(HeroPower playerHeroPower);

    public abstract void healHeroPower(HeroPower playerHeroPower);

    public abstract void endGame();

    public abstract void botMechanics();

    public abstract void playerMechanics();

    public abstract void commit();

    public abstract void playWeapon(Card card);

    public abstract void attackWithWeapon();

    public abstract void spellDamage(CardSpell card);
}
