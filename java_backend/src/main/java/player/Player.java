package player;

import cardCollection.Cards;
import cardCollection.Deck;
import cards.Card;
import cards.CardMinion;
import heroes.Hero;

public class Player {
    private Hero hero;
    private Deck deck;
    private Cards cardsInHand;

    public Player(PlayableDeck playableDeck) {
//        if (playableDeck.getDeck().valid()){
            this.hero = playableDeck.getHero();
            this.deck = playableDeck.getDeck();
            cardsInHand = new Cards();
//        }
    }

    public Player(Deck deck,Hero hero) {
        this.deck = deck;
        this.hero = hero;
        cardsInHand = new Deck();
    }

    public Card drawCard() {
        Card out = deck.drawRandom();
        cardsInHand.addCard(out);
        return out;
    }
    public CardMinion drawMinionCard(){
        CardMinion out = (CardMinion) deck.drawRandom();
        out.setAttack(3); // TODO: override voor test
        cardsInHand.addCard(out);
        return out;
    }

    public Card playCard(String id) {
        return cardsInHand.drawById(id);
    }

    public Hero getHero() {
        return hero;
    }

    public Deck getDeck() {
        return deck;
    }

    public Cards getCardsInHand() {
        return cardsInHand;
    }

    public boolean isAlive(){
        return hero.isAlive();
    }

    @Override
    public String toString() {
        return "Player{" +
                "hero=" + hero +
                ", deck=" + deck +
                ", cardsInHand=" + cardsInHand +
                '}';
    }
}
