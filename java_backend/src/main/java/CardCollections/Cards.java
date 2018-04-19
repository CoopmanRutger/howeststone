package CardCollections;

import java.util.HashSet;
import java.util.Set;

public class Cards {
    Set cards = new HashSet();

    public Cards(Set cards) {
        this.cards = cards;
    }

    public Cards() {}

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
        return new Cards.CardSpell("cardID", 0, "name", "../", "type");
    }
}
