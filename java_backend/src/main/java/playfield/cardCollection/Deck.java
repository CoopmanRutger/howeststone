package playfield.cardCollection;

import playfield.cardCollection.cards.Card;
import java.util.List;

public class Deck extends Cards {

    private final int maxCards = 30;

    public Deck(List<Card> cards) {
        super(cards);
    }

    public Deck() {
        super();
    }


    public void addCard(Card card) {
        try {
            // sets bevatten geen dubbele waardes!
            if (containsDouble(card)) {
                throw new Exception("There already are two of the same cards!");
            } else if (getAmount() < maxCards) {
                cards.add(card);
            } else {
                throw new Exception("More than 30 cards!");
            }
        } catch (Exception Ex) {
            // laat gebruiker weten datt nie gelukt is
        }

    }

    public boolean valid() {
        System.out.println("amount of cards in checked deck is: " + getAmount());
        return getAmount() == maxCards;
    }

    private boolean containsDouble(Card card) {
        return amountOfCards(card) > 1;
    }

    private int amountOfCards(Card card) {
        int amount = 0;
        for (Card c : cards) {
            if (c.equals(card)) {
                amount++;
            }
        }
        return amount;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
