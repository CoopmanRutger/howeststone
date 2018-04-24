package CardCollection;

import java.util.HashSet;
import java.util.Set;

public class Cards {
    private Set<Cards.Card> cards;

    public Cards(Set cards) {
        this.cards = cards;
    }

    public Cards() {
        cards = new HashSet<>();
    }

    public void add(Cards.CardMinion card) {
        cards.add(card);
    }

    public void add(Cards.CardSpell card) {
        cards.add(card);
    }

    public void add(Cards.CardWeapon card) {
        cards.add(card);
    }

    public Cards.Card get(){
        Cards.Card cardToReturn = cards.iterator().next();
        cards.remove(cardToReturn);
        return cardToReturn;
    }
}
