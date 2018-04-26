package cardCollection;

import java.util.HashSet;
import java.util.Set;

import cards.Card;
import cards.CardMinion;
import cards.CardSpell;
import cards.CardWeapon;

public class Cards {
    private Set<Card> cards;

    public Cards(Set<Card> cards) {
        this.cards = cards;
    }

    public Cards() {
        cards = new HashSet<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public Set<Card> getCards() {
        Set<Card> set = new HashSet<>();
        set.addAll(cards);
        return set;
    }

    public Card pop(){
        Card cardToReturn = cards.iterator().next();
        cards.remove(cardToReturn);
        return cardToReturn;
    }

    public int getAmountOfCards(){
        return cards.size();
    }
}
