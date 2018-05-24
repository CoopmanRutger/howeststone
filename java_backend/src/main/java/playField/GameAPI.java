package playField;

import playField.cardCollection.Deck;
import playField.cardCollection.cards.Card;
import playField.player.PlayableDeck;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

public class GameAPI extends Game {
    public GameAPI(PlayableDeck playerDeck, PlayableDeck opponentDeck) {
        super(playerDeck, opponentDeck);
    }

    @Override
    protected void endGame() {

    }

    @Override
    protected void botMechanics() {

    }

    @Override
    protected void playerMechanics() {

    }

    @Override
    protected void commit() {

    }

    @Override
    protected void playWeapon(Card card) {

    }

    @Override
    protected void attackWithWeapon() {

    }

    @Override
    protected void spellDamage(CardSpell card) {

    }

    @Override
    protected void addArmour(int amount) {

    }

    @Override
    protected void addAttack(int amount) {

    }


    @Override
    protected void addHealth(int healthToGive) {

    }

    @Override
    protected void attackHeroPower(HeroPower playerHeroPower) {

    }

    @Override
    protected void healHeroPower(HeroPower playerHeroPower) {

    }
}
