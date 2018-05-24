package playField.cardCollection;

import playField.cardCollection.cards.Card;
import java.util.List;

public class Deck extends Cards{

    public Deck(List<Card> cards) {
        super(cards);
    }

    public Deck() {
        super();
    }


    public void addCard(Card card){
        try{
            if (containsDouble(card)){  // sets bevatten geen dubbele waardes!
                throw new Exception("There already are two of the same cards!");
            } else if(getAmount()<30) {
                cards.add(card);
            } else {
                throw new Exception("More than 30 cards!");
            }
        } catch (Exception Ex) {
            // laat gebruiker weten datt nie gelukt is
        }

    }

    public boolean valid(){
        return getAmount()==30;
    } // TODO: 18/05/2018 make a constant

    private boolean containsDouble(Card card) {
        int amount = 0;
        for (Card c : cards) { // TODO: 18/05/2018 aparte methode maken cardCount
            if (c.equals(card)){
                amount++;
            }
        }
        return amount > 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
