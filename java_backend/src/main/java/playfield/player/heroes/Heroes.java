package playfield.player.heroes;

import playfield.cardCollection.Cards;

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
}
