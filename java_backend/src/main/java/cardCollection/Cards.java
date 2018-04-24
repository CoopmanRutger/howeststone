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

    public void add(CardMinion card) {
        cards.add(card);
    }

    public void add(CardSpell card) {
        cards.add(card);
    }

    public void add(CardWeapon card) {
        cards.add(card);
    }

    public Card get(){
        Card cardToReturn = cards.iterator().next();
        cards.remove(cardToReturn);
        return cardToReturn;
    }
}
