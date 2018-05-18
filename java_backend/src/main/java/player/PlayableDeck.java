package player;

import cardCollection.Deck;
import heroes.Hero;

import java.util.List;

public class PlayableDeck {
    private  String deckName;
    private Hero hero;
    private Deck deck;

    public PlayableDeck(String deckName, Hero hero, Deck deck) {
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
}
