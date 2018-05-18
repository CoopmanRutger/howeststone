package player;

import cardCollection.Cards;
import cardCollection.Deck;
import cards.Card;
import cards.CardMinion;
import heroes.Hero;
import heroes.HeroPower;

public class Player {
    private Hero hero;
    private Deck deck;
    private Cards cardsInHand;
    private Cards cardsOnField;

    public Player(Deck deck, Hero hero) {
        if (deck.valid()) {
            this.hero = hero;
            this.deck = deck;
            cardsInHand = new Cards();
            cardsOnField = new Cards();
            System.out.println(cardsOnField);
        }
    }

    public Player(PlayableDeck playableDeck) {
        this(playableDeck.getDeck(), playableDeck.getHero());
    }

    public Cards getCardsOnField() {
        return cardsOnField;
    }

    public Card drawCard() {
        Card out;
        if (cardsInHand.getAmount() < 10) {
            out = deck.drawRandom();
            cardsInHand.addCard(out);
        } else out = null;
        return out;
    }

    public Hero getHero() {
        return hero;
    }

    public Deck getDeck() {
        return deck;
    }

    public Cards getCardsInHand() {
        return cardsInHand;
}

    public boolean isAlive() {
        return hero.isAlive();
    }

    public int getManaFromId(String id) {
        return cardsInHand.findById(id).getMana();
    }

    public void playCard(String id) {
        Card card = cardsInHand.findById(id);
        cardsOnField.addCard(
                cardsInHand.findById(id)
        );
        cardsInHand.remove(card);
    }

    @Override
    public String toString() {
        return "Player{" +
                "hero=" + hero +
                ", deck=" + deck +
                ", cardsInHand=" + cardsInHand +
                '}';
    }
}
