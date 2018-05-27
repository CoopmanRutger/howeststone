package playfield;

import playfield.player.PlayableDeck;
import playfield.player.heroes.Hero;

import java.util.Set;

public class GameState {
    // voor deckbuilder lvl 1
    protected String tempHero;

    protected Game game;

    protected PlayableDeck playerDeck;
    protected PlayableDeck opponentDeck;
    protected Hero playerHero;
    protected Hero opponentHero;
    protected Set<PlayableDeck> playableDeckSet;
}
