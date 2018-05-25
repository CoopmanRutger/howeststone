package playField;

import playField.cardCollection.Cards;
import playField.cardCollection.Deck;
import playField.cardCollection.cards.Card;
import playField.cardCollection.cards.CardSpell;
import playField.player.PlayableDeck;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

import java.util.ArrayList;
import java.util.List;

public class GameAPI extends Game {

    public GameAPI(PlayableDeck playerDeck, PlayableDeck opponentDeck) {
        super(playerDeck, opponentDeck);
    }

    public GameAPI() {
        super();
    }

    @Override
    public void endGame() {

    }

    @Override
    public void botMechanics() {
        // GETTING PLAYABLE CARDS

        Cards playable = pf.getOpponent().getCardsInHand();

        boolean running = true;
        boolean played;
        List<Card> toRemove;

        while (running) {
            played = false;


            // GETTING CARDS TO PLAY

            toRemove = new ArrayList<>();
            for (Card card : playable.getCards()) {
                if (card.getMana() <= pf.getCurMana()) {
                    played = true;
                    toRemove.add(card);
                }
            }
            // PLAYING CARDS TO PLAY

            for (Card card : toRemove) playCard(card.getCardId());
//            for (Card card : toRemove) playCard(card.getCardId());
            if (!played) running = false;
        }

        // ATTACKING IF POSSIBLE

        // GETTING CARDS TO ATTACK

        Cards toAttack = pf.getOpponent().getCardsOnField();
        int damage;

        // ATTACKING

        for (Card card : toAttack.getCards()) {
            attackHero(card.getCardId());
        }

        // DRAWING NEW CARD

        pf.getOpponent().drawCard();
    }

    @Override
    public void playerMechanics() {

    }

    @Override
    public void commit() {
        pf.increment();
    }

    @Override
    public void playWeapon(Card card) {

    }

    @Override
    public void attackWithWeapon() {

    }

    @Override
    public void spellDamage(CardSpell card) {

    }

    @Override
    public void addArmour(int amount) {

    }

    @Override
    public void addAttack(int amount) {

    }


    @Override
    public void addHealth(int healthToGive) {

    }

    @Override
    public void attackHeroPower(HeroPower playerHeroPower) {

    }

    @Override
    public void healHeroPower(HeroPower playerHeroPower) {

    }
}
