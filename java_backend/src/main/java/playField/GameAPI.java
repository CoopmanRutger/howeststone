package playField;

import playField.cardCollection.Deck;
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
    protected void addArmour(int amount) {

    }

    @Override
    protected void addHealth() {

    }

    @Override
    protected void addAttack() {

    }

    @Override
    protected void attackHeroPower(HeroPower playerHeroPower) {

    }

    @Override
    protected void healHeroPower(HeroPower playerHeroPower) {

    }
}
