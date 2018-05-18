package playField;

import cardCollection.Cards;
import cards.Card;
import cards.CardMinion;
import player.Player;

import java.util.Random;

public class PlayingField {
    // TODO: 18/05/2018 mischien gewoon apparte velden maken
    // TODO: 18/05/2018 abstractie
    private Player players[] = new Player[2];
    private Cards[] cardsOnField = new Cards[2]; // TODO: 18/05/2018 waarom nie in player zelf?
    private boolean isOpponent[] = new boolean[2];

    private static final int maxMana = 10;
    private int mana;
    private int index = 0; // for your turn (you are for example 1, adversary = 0)
    private boolean begins;

    public PlayingField(Player player, Player opponent) {
        Random r = new Random();
        begins = r.nextInt(2) == 0;

        this.begins = begins;

        int subIndex;

        if (begins) {
            subIndex = 0;
        } else {
            subIndex = 1;
        }

        players[subIndex] = player;
        isOpponent[subIndex] = false;

        subIndex++;
        subIndex %= 2;
        
        players[subIndex] = opponent;
        isOpponent[subIndex] = true;

        cardsOnField[0] = new Cards();
        cardsOnField[1] = new Cards();

        for (int i = 0; i < 3; i++) {
            drawCard();
        }
        increment();

        for (int i = 0; i < 3; i++) {
            drawCard();
        }

        increment();
    }

    public int minionAttack(CardMinion card){
        return  card.getAttack();
    }

    public void increment() {
        index++;
        calculateMana();
    }

    public int calculateMana() {
        if (index/2 < maxMana){
            return index/2;
        } else {
            return maxMana;
        }
    }

    public int getMana() {
        return mana;
    }

    public Player getCurrentPlayer(){
        return players[index%2];
    }

    public void drawCard(){
        getCurrentPlayer().drawCard();
    }

    public void playCard(String id){
        Card card = getCurrentPlayer().getCardsInHand().findById(id);
        if (card.getMana() <= mana){
            cardsOnField[index].addCard(
                    getCurrentPlayer().playCard(id)
            );
            mana -= card.getMana();
        }
    }

    public boolean isOpponent () {
        return isOpponent[index];
    }

    public Cards getCardsOnFieldOpponent() {
        if (begins){
            return cardsOnField[1];
        } else {
            return cardsOnField[0];
        }
    }

    public Cards getCardsOnFieldPlayer() {
        if (begins){
            return cardsOnField[0];
        } else {
            return cardsOnField[1];
        }
    }

    @Override
    public String toString() {
        int subIndex = index;

        String out = "";

        out += players[subIndex].getCardsInHand() +"\n" +
                cardsOnField[subIndex] + "\n";

        subIndex++;
        subIndex %= 2;

        out += players[subIndex].getCardsInHand() +"\n" +
                cardsOnField[subIndex] + "\n";

        return out;
    }
}
