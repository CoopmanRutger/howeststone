package cardCollection;


import cards.Card;

public class Deck extends Cards {

    private Cards cards1;
    private Cards cards2;

    public void addCards(Card card){

//        Exception Ex = new Exception();
        try{
            if (!cards1.contains(card)){  // sets bevatten geen dubbele waardes!
                cards1.add(card);
            } else if (!cards2.contains(card)) {
                cards2.add(card);
            } else {
                throw new Exception("blabal");
            }
        } catch (Exception Ex) {
            
        }
    }

    public int maxCards(Card card){
        if ((cards1.getAmountOfCards() + cards2.getAmountOfCards()) <= 30){

        }
    }


}
