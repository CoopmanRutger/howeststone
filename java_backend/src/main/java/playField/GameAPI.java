package playField;

import playField.cardCollection.Deck;
import playField.cardCollection.cards.Card;
import playField.cardCollection.cards.CardSpell;
import playField.player.PlayableDeck;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

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
