package player;

import cardCollection.Deck;
import heroes.Hero;

public class Player {
    private Hero hero;
    private Deck deck;

    public Player(Hero hero, Deck deck) {
        this.hero = hero;
        this.deck = deck;
    }

    public Hero getHero() {
        return hero;
    }

    public Deck getDeck() {
        return deck;
    }
}
