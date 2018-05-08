package player;

import cardCollection.Cards;
import cardCollection.Deck;
import cards.Card;
import heroes.Hero;

public class Player {
    private Hero hero;
    private Deck deck;
    private Cards cardsInHand;

    public Player(PlayableDeck playableDeck) {
//        if (playableDeck.getDeck().valid()){
            this.hero = playableDeck.getHero();
            this.deck = playableDeck.getDeck();
            cardsInHand = new Cards();
//        }
    }



    public Player(Deck deck,Hero hero) {
        this.deck = deck;
        this.hero = hero;
        cardsInHand = new Deck();
    }

    public Card drawCard() {
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

    public Cards getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(Cards cardsInHand) {
        this.cardsInHand = cardsInHand;
    }
}
