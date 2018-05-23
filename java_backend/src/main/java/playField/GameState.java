package playField;

import playField.cardCollection.Deck;
import playField.player.PlayableDeck;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;
import playField.player.Player;

import java.util.Set;

public class GameState{
    protected Game game;

    protected PlayableDeck playerDeck;
    protected PlayableDeck opponentDeck;
    protected Hero playerHero;
    protected Hero opponentHero;
    protected Set<PlayableDeck> playableDeckSet;
}
