package model;

import java.util.HashSet;
import java.util.Set;

public class Cards {
    Set cards = new HashSet();

    public Cards(Set cards) {
        this.cards = cards;
    }

    public Cards() {}

    public void add(CardMinion card) {
        cards.add(card);
    }

    public void add(CardSpells card) {
        cards.add(card);
    }

    public void add(CardWeapon card) {
        cards.add(card);
    }
}
