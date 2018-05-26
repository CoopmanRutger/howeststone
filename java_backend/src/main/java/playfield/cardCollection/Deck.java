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
        return getAmount() == maxCards;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
