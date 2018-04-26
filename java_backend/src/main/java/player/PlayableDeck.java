package player;

import cardCollection.Deck;
import heroes.Hero;

public class PlayableDeck {
    private Hero hero;
    private Deck deck;

    public PlayableDeck(Hero hero, Deck deck) {
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
