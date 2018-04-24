package heroes;

import cardCollection.Cards;

import java.util.Map;

public class heroes {
    Map<Hero, Cards> cardChoices;

    public heroes(Map<Hero, Cards> cardChoices) {
        this.cardChoices = cardChoices;
    }

    public heroes() {
    }

    public Cards getCards(Hero hero) {
        return cardChoices.get(hero);
    }

//    public Cards getCards(String id) {
//        return cardChoices.get(id);
//    }
}
