package playField.player.heroes;

import playField.cardCollection.Cards;

import java.util.Map;

public class Heroes {
    private Map<Hero, Cards> cardChoices;

    public Heroes(Map<Hero, Cards> cardChoices) {
        this.cardChoices = cardChoices;
    }

    public Heroes() {
    }

    public Cards getCards(Hero hero) {
        return cardChoices.get(hero);
    }
//    public void setCard(Map<Hero, Cards> cardChoices) {
//        this.cardChoices = cardChoices;
//    }

    //    public Cards getCards(String id) {
//        return cardChoices.get(id);
    //}
}
