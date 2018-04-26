package cardCollection;


import cards.Card;

public class Deck {

    private Cards cards1 = new Cards();
    private Cards cards2 = new Cards();

    public void addCards(Card card){
//        Exception Ex = new Exception();
        if (getAmount()<30) {
            try{
                if (!cards1.contains(card)){  // sets bevatten geen dubbele waardes!
                    cards1.add(card);
                } else if (!cards2.contains(card)) {
                    cards2.add(card);
                } else {
                    throw new Exception("meer dan 2 dezelfde kaarten");
                }
            } catch (Exception Ex) {
                // laat gebruiker weten datt nie gelukt is
            }
        }
    }

    public Card pop(){
        Card cardToReturn = cards1.pop();
        if (cards2.contains(cardToReturn)) {
            cards2.remove(cardToReturn);
            cards1.add(cardToReturn);
        }
        return cardToReturn;
    }

    public int getAmount(){
        return cards1.getAmount() + cards2.getAmount();
    }
}
