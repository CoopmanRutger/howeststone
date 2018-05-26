package playfield.cardCollection;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import playfield.cardCollection.cards.Card;
import playfield.cardCollection.cards.CardMinion;

public class Cards {
    @JsonProperty("cards")
    protected List<Card> cards;

    Cards(List<Card> cards) {

        this.cards = cards;
    }

    public Cards() {

        cards = new ArrayList<>(30);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addAllCards(Cards cards) {
        for (Card card : cards.getCards()) {
            this.addCard(card);
        }
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public Card findById(String id) {
        for (Card c : cards) {
            if (c.getCardId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    //zoekt kaart op id en verwijderd ze
    public Card drawById(String id) {
        final Card c = findById(id);
        remove(c);
        return c;
    }

    protected boolean containsDouble(Card card) {
        return amountOfCards(card) > 1;
    }

    private int amountOfCards(Card card) {
        return getCards(card).size();
    }

    private ArrayList<Card> getCards(Card card) {
        ArrayList<Card> array = new ArrayList<>();
        for (Card c : cards) {
            if (c.equals(card)) {
                array.add(c);
            }
        }
        return array;
    }

    private Random r = new Random();
    public Card drawRandom() {
        return cards.remove(r.nextInt(cards.size()));
    }

    public void remove(Card card) {
        cards.remove(card);
    }

    public void remove(String id) {
        cards.remove(findById(id));
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public boolean contains(String id) {
        return cards.contains(findById(id));
    }

    public int getAmount() {
        return cards.size();
    }

    @Override
    public String toString() {
        final StringBuilder out = new StringBuilder();

        for (Card c: cards) {
            out.append(c.toString());
        }

        return out.toString();
    }

    public Card getCanAttack(Card card) {
        for (Card c : getCards(card)) {
            if (((CardMinion) c).getCanAttack()) {
                return c;
            }
        }
        return null;
    }

    public Card getCanAttack(String id) {
        Card card = findById(id);
        if (card != null) {
            return getCanAttack(card);
        }
        return null;
    }
}
