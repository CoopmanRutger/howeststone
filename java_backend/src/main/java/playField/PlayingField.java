package playField;

import cardCollection.Cards;
import player.Player;

public class PlayingField {
    private Player players[] = new Player[2];
    private Cards[] cardsOnField = new Cards[2];
    private boolean isOpponent[] = new boolean[2];

    private int turn = 0;
    private static final int maxMana = 10;
    private short index = 0; // for your turn (you are for example 1, adversary = 0)

    public PlayingField(Player player, Player opponent, boolean begins) {
        int subIndex;

        if (begins) {
            subIndex = 0;
        } else {
            subIndex = 1;
        }

        players[subIndex] = player;
        isOpponent[subIndex] = false;

        subIndex = subIndex + 1 % 2;
        
        players[subIndex] = opponent;
        isOpponent[subIndex] = true;

        cardsOnField[0] = new Cards();
        cardsOnField[1] = new Cards();

        for (int i = 0; i < 3; i++) {
            drawCard();
        }
        incerement();

        for (int i = 0; i < 3; i++) {
            drawCard();
        }

        incerement();
    }

    public void increment(){
        if (index == 1) {
            turn++;
            index = 0;
        } else if (index == 0) {
            index++;
        } else {
//          // TODO  't is nie gelukt
        }
    }

    public int getMana(){

        if (turn < maxMana){
            return turn;
        } else {
            return maxMana;
        }
    }

    public Player getCurrentPlayer(){
        return players[index];
    }

    public void drawCard(){
        getCurrentPlayer().drawCard();
    }

    public void playCard(String id){
        cardsOnField[index].addCard(
                getCurrentPlayer().playCard(id)
        );
    }

    @Override
    public String toString() {
        int index2 = index + 1 % 2;

        String out = "";

        out += players[index].getCardsInHand();
        out += "\n";
        out += cardsOnField[index];
        out += "\n";
        out += players[index2].getCardsInHand();
        out += "\n";
        out += cardsOnField[index2];
        out += "\n";

        return out;
    }
}
