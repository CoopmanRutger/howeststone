package playField;

import playField.cardCollection.Deck;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;
import playField.player.Player;

public class GameState{
    protected Game game;

    protected Deck playerDeck;
    protected Deck opponentDeck;
    protected Hero playerHero;
    protected Hero opponentHero;
}
