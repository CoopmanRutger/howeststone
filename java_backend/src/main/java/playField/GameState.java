package playField;

import playField.player.PlayableDeck;
import playField.player.heroes.Hero;

import java.util.Set;

public class GameState{
    // voor deckbuilder lvl 1
    protected String tempHero;

    protected Game game = new GameAPI();

    protected PlayableDeck playerDeck;
    protected PlayableDeck opponentDeck;
    protected Hero playerHero;
    protected Hero opponentHero;
    protected Set<PlayableDeck> playableDeckSet;
}
