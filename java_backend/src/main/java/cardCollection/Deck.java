package cardCollection;

import cards.Card;
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
                throw new Exception("er zijn 2 dezelfde kaarten");
            } else if(getAmount()<30) {
                cards.add(card);
            } else {
                throw new Exception("meer dan 30 kaarten!");
            }
        } catch (Exception Ex) {
            // laat gebruiker weten datt nie gelukt is
        }

    }

    public boolean valid(){
        return getAmount()==30;
    }

    private boolean containsDouble(Card card) {
        int amount = 0;
        for (Card c : cards) {
            if (c.equals(card)){
                amount++;
            }
        }
        return amount>1;
    }
}
