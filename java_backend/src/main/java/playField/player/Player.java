package playfield.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import playfield.cardCollection.Cards;
import playfield.cardCollection.Deck;
import playfield.cardCollection.cards.Card;
import playfield.cardCollection.cards.CardWeapon;
import playfield.player.heroes.Hero;

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
        } else {
            System.out.println("den deck was nie valid");
        }
    }

    public Player(PlayableDeck playableDeck) {
        this(playableDeck.getDeck(), playableDeck.getHero());
        System.out.println("Playertjes maken me nen playable deck");
        System.out.println("deck");
        System.out.println(playableDeck.getDeck());
        System.out.println("hero");
        System.out.println(playableDeck.getHero());
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
        final Card card = cardsInHand.findById(id);
        if (card != null) {
            return cardsInHand.findById(id).getMana();
        } else {
            return -1;
        }
    }

    // TAKES A RANDOM CARD FROM YOUR DECK AND PUT'S IT IN YOUR HAND
    public Card drawCard() {
        final Card out;
        System.out.println("Is cardsInHands null? " + cardsInHand);
        if (cardsInHand.getAmount() < 10) {
            out = deck.drawRandom();
            cardsInHand.addCard(out);
        } else {
            out = null;
        }
        return out;
    }
    // PLAY'S A CARD FROM YOUR HAND TO "CARDSONFIELD" BASED ON ID
    public void playCard(String id) {
        final Card card = cardsInHand.findById(id);
        cardsOnField.addCard(
                card
        );
    }

    // TOSTRING

    @Override
    public String toString() {
        return "Player{"
                + "hero=" + hero
                + ", cardsInHand\n" + cardsInHand + '}';
    }

    public CardWeapon getWeapon() {
        return weapon;
    }

    public void setWeapon(CardWeapon weapon) {
        this.weapon = weapon;
    }

    public void moveBack(String id) {
        final Card card = cardsInHand.drawById(id);
        deck.addCard(card);
    }
}
