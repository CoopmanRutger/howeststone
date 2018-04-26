package cardCollection;

import java.util.*;

import cards.Card;

public class Cards {
    protected List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public Cards() {
        cards = new ArrayList<>(30);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    protected Card findById(String id) {
        for(Card c : cards) {
            if (c.getCardId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Card drawById(String id){
        Card c = findById(id);
        remove(c);
        return c;
    }

    private Random r = new Random();
    public Card drawRandom(){
        return cards.remove( r.nextInt(cards.size()) );
    }

    public void remove(Card card){
        cards.remove(card);
    }

    public void remove(String id){
        cards.remove(findById(id));
    }

    public boolean contains(Card card){
        return cards.contains(card);
    }

    public boolean contains(String id){
        return cards.contains(findById(id));
    }

    public int getAmount(){
        return cards.size();
    }
}
