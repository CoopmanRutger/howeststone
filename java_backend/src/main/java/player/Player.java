package player;

import cardCollection.Deck;
import cards.Card;
import heroes.Hero;

public class Player {
    private Hero hero;
    private Deck deck;
    private Deck cardsInHand;

    public Player(PlayableDeck playableDeck) {
        this.hero = playableDeck.getHero();
        this.deck = playableDeck.getDeck();
        cardsInHand = new Deck();
    }

    public Card drawCards() {
        Card out = deck.drawRandom();
        cardsInHand.addCard(out);
        return out;
    }

    public Card playCard(String id) {
        return cardsInHand.drawById(id);
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Deck getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(Deck cardsInHand) {
        this.cardsInHand = cardsInHand;
    }
}
