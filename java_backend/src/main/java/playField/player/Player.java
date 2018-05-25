package playField.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import playField.cardCollection.Cards;
import playField.cardCollection.Deck;
import playField.cardCollection.cards.Card;
import playField.cardCollection.cards.CardAbility;
import playField.cardCollection.cards.CardWeapon;
import playField.player.heroes.Hero;

public class Player {
    @JsonProperty("hero")
    private Hero hero;
    private Deck deck;
    @JsonProperty("cardsInHand")
    private Cards cardsInHand;
    @JsonProperty("cardOnField")
    private Cards cardsOnField;
    @JsonProperty("weapon")
    private CardWeapon weapon;

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
        Card card = cardsInHand.findById(id);
        if (card != null) return cardsInHand.findById(id).getMana();
        else return -1;
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
    }

    // TOSTRING

    @Override
    public String toString() {
        return "Player{" +
                "hero=" + hero +
                ", cardsInHand\n" + cardsInHand +
                '}';
    }

    public CardWeapon getWeapon() {
        return weapon;
    }

    public void setWeapon(CardWeapon weapon) {
        this.weapon = weapon;
    }

    public void moveBack(String id) {
        Card card = cardsInHand.drawById(id);
        deck.addCard(card);
    }
}
