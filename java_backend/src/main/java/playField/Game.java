package playField;

import playField.cardCollection.Deck;

import playField.cardCollection.cards.*;

import playField.cardCollection.cards.Card;
import playField.cardCollection.cards.CardMinion;
import playField.player.PlayableDeck;
import playField.player.Player;

import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static playField.cardCollection.cards.CardAbility.*;
import static playField.player.heroes.AbilityType.*;


public abstract class Game {

    public PlayingField pf;

    // CONTRUCTOR

    public Game(PlayableDeck playerDeck, PlayableDeck opponentDeck){

        pf = new PlayingField(new Player(playerDeck), new Player(opponentDeck));
    }

    public Game(){
        Set<CardAbility> tempSet;

        Deck playerDeck = new Deck();
        Deck opponentDeck = new Deck();

        for (int i = 0; i < 30; i++) {
            tempSet = new HashSet<>();
            tempSet.add(spellDamage);
            playerDeck.addCard(new CardMinion("ID" + i, "name" + i, "type", 1, "type", "heroType", "http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_015.png",2, 2,"", "", new HashSet<CardAbility>()));

            tempSet = new HashSet<>();
//            tempSet.add(divineShield);
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

            if (pf.whosTurn()) botMechanics();
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

    // POSSIBLE ACTIONS

    public void playCard(String pId) {
        Player curPlayer = pf.getCurrentPlayer();

        Card card = curPlayer.getCardsInHand().findById(pId);
        int mana = curPlayer.getManaFromId(pId);

        if (card != null && mana <= pf.getCurMana()) {
            String type = card.identifier();
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
        }
        curPlayer.getCardsInHand().remove(card);
        pf.decrMana(mana);
    }

    public void spell(Set<CardAbility> abilities, CardSpell card) { // does spell-action
        if (abilities.contains(drawCard)) pf.getCurrentPlayer().drawCard();
        if (abilities.contains(directAttack)) attackWithWeapon();
        if (abilities.contains(addArmour)) addArmour(card.getArmourToGive());
        if (abilities.contains(addHealth)) addHealth(card.getHealthToGive());
        if (abilities.contains(addAttack)) addAttack(card.getAttackToGive());
        if (abilities.contains(spellDamage)) spellDamage(card);
    }


    // ABSTRACT SPELS

    public void addArmour(int amount){
        pf.getCurrentPlayer().getHero().incrArmour(amount);
    }

    public void addHealthHero(int healAmount) {
        pf.getCurrentPlayer().getHero().incrHealth(healAmount);
    }

    public void addHealthCard(int healAmount, String id) {
        Player curPlayer =  pf.getCurrentPlayer();
        CardMinion card = ((CardMinion) curPlayer.getCardsOnField().findById(id));

        if (card != null) card.incrHealth(healAmount);
    }

    // ABSTRACT SPELS

    public abstract void addAttack(int amount);


    // BASIC METHOD'S
    public void attackCard(String pId, String oId) {
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

    public void attackHero(String pId) {
        CardMinion playerCard = (CardMinion) pf.getCurrentPlayer().getCardsOnField().findById(pId);
        Hero hero = pf.getOppositePlayer().getHero();

        if (playerCard != null && hero != null && playerCard.getCanAttack()) {
            int damage = playerCard.getAttack();

            hero.takeDamage(damage);

            playerCard.incrCanAttack(false);

            if (!hero.isAlive()) commit();
        }
    }

    public void playHeroPower() {
        HeroPower heroPower = pf.getCurrentPlayer().getHero().getHeroPower();

        int mana = heroPower.getManaCost();

        if (mana <= pf.getCurMana()) {
            if (heroPower.getAbilityType() == attack)
                attackHeroPower(heroPower);
            else healHeroPower(heroPower);

            pf.decrMana(mana);
        }
    }

    public void playWeaponOnCard(String oId, int damage) {
        CardMinion opponentCard = (CardMinion) pf.getOppositePlayer().getCardsOnField().findById(oId);

        if (opponentCard != null){
            opponentCard.takeDamage(damage);
        }
    }

    public void playWeaponOnHero(int damage) {
        Hero hero = pf.getOppositePlayer().getHero();
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
