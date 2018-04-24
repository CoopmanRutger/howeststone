package heroes;

import cardCollection.Cards;

import java.util.Map;

public class Heroes {
    Map<Hero, Cards> cardChoices;

    public Heroes(Map<Hero, Cards> cardChoices) {
        this.cardChoices = cardChoices;
    }

    public Heroes() {
    }

    public Cards getCards(Hero hero) {
        return cardChoices.get(hero);
    }

//    public Cards getCards(String id) {
//        return cardChoices.get(id);
//    }
}
