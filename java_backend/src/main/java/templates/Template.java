package templates;

import cardCollection.Deck;
import heroes.Hero;

public class Template {
    private Hero hero;
    private Deck deck;

    public Template(Hero hero, Deck deck) {
        this.hero = hero;
        this.deck = deck;
    }

    public Hero getHero() {
        return hero;
    }

    public Deck getDeck1() {
        return deck;
    }
}
