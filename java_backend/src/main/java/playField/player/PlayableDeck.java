package playField.player;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import playField.cardCollection.Deck;
import playField.player.heroes.Hero;

public class PlayableDeck {
    @JsonProperty("deckName")
    private String deckName;
    @JsonProperty("hero")
    private Hero hero;
    @JsonProperty("deck")
    private Deck deck;

    @JsonCreator
    public PlayableDeck(@JsonProperty("deckName")String deckName,
                        @JsonProperty("hero")Hero hero,
                        @JsonProperty("deck")Deck deck) {
        this.deckName = deckName;
        this.hero = hero;
        this.deck = deck;
    }

    public Hero getHero() {
        return hero;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    @Override
    public String toString() {
        return "PlayableDeck{"
                + "deckName='" + deckName + '\''
                + ", hero=" + hero
                + ", deck=" + deck
                + '}';
    }
}
