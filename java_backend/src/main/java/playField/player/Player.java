package playField.player;

import playField.cardCollection.Cards;
import playField.cardCollection.Deck;
import playField.cardCollection.cards.Card;
import playField.player.heroes.Hero;

public class Player {
    private Hero hero;
    private Deck deck;
    private Cards cardsInHand;
    private Cards cardsOnField;

    // CHAINED CONSTRUCTORS

    public Player(Deck deck, Hero hero) {
        if (deck.valid()) {
            this.hero = hero;
            this.deck = deck;
            cardsInHand = new Cards();
            cardsOnField = new Cards();
        }
    }

    public Player(PlayableDeck playableDeck) {
        this(playableDeck.getDeck(), playableDeck.getHero());
    }

    // GETTERS AND SETTERS

    public Cards getCardsOnField() {
        return cardsOnField;
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

    // THE GOOD STUFF

    public boolean isAlive() {
        return hero.isAlive();
    }

    public int getManaFromId(String id) {
        return cardsInHand.findById(id).getMana();
    }

    public Card drawCard() { // TAKES A RANDOM CARD FROM YOUR DECK AND PUT'S IT IN YOUR HAND
        Card out;
        if (cardsInHand.getAmount() < 10) {
            out = deck.drawRandom();
            cardsInHand.addCard(out);
        } else out = null;
        return out;
    }

    public void playCard(String id) { // PLAY'S A CARD FROM YOUR HAND TO "CARDSONFIELD" BASED ON ID
        Card card = cardsInHand.findById(id);
        cardsOnField.addCard(
                card
        );
        cardsInHand.remove(card);
    }

    // TOSTRING

    @Override
    public String toString() {
        return "Player{" +
                "hero=" + hero +
                ", cardsInHand=" + cardsInHand +
                '}';
    }
}
