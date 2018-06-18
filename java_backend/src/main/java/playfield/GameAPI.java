package playfield;

import playfield.cardCollection.Cards;
import playfield.cardCollection.cards.Card;
import playfield.cardCollection.cards.CardSpell;
import playfield.player.PlayableDeck;
import playfield.player.heroes.HeroPower;

import java.util.ArrayList;
import java.util.List;

public class GameAPI extends Game {

    public GameAPI(PlayableDeck playerDeck, PlayableDeck opponentDeck) {
        super(playerDeck, opponentDeck);
    }

    @Override
    public void endGame() {

    }

    @Override
    public void botMechanics() {
        // GETTING PLAYABLE CARDS

        final Cards playable = pf.getOpponent().getCardsInHand();

        boolean running = true;
        boolean played;
        List<Card> toRemove;

        while (running) {
            played = false;


            // GETTING CARDS TO PLAY
            int amountOfCards = pf.getOpponent().getCardsOnField().getAmount();
            toRemove = new ArrayList<>();
            for (Card card : playable.getSpecificCards()) {
                if (card.getMana() <= pf.getCurMana() && amountOfCards < 7) {
                    amountOfCards++;
                    played = true;
                    toRemove.add(card);
                }
            }
            // PLAYING CARDS TO PLAY

            for (Card card : toRemove) {
                playCard(card.getCardId());
            }
            //for (Card card : toRemove) playCard(card.getCardId());
            if (!played) {
                running = false;
            }
        }

        // ATTACKING IF POSSIBLE

        // GETTING CARDS TO ATTACK

        final Cards toAttack = pf.getOpponent().getCardsOnField();
        final int damage;

        // ATTACKING

        for (Card card : toAttack.getSpecificCards()) {
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
        updateCanAttack();
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
