package playField;

import playField.cardCollection.Deck;
import playField.cardCollection.cards.Card;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

public class GameAPI extends Game {
    public GameAPI(Deck playerDeck, Deck opponentDeck, Hero playerHero, Hero opponentHero) {
        super(playerDeck, opponentDeck, playerHero, opponentHero);
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
