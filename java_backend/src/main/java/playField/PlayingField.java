package playField;

import cardCollection.Cards;
import player.Player;

public class PlayingField {
    Player players[] = new Player[2];
    private Cards[] cardsOnField = new Cards[2];
    boolean isOpponent[] = new boolean[2];

    private int turn = 1;
    private static final int maxMana = 10;
    private short index = 0;

    public PlayingField(Player player, Player opponent, boolean begins) {
        cardsOnField[0] = new Cards();
        cardsOnField[1] = new Cards();

        if (begins) {
            players[0] = player;
            isOpponent[0] = false;
            players[1] = opponent;
            isOpponent[1] = true;
        } else {
            players[1] = player;
            isOpponent[1] = false;
            players[0] = opponent;
            isOpponent[0] = true;
        }

    }

    private void incerement(){
        if (index == 1) {
            turn++;
            index = 0;
        } else if (index == 0) {
            index++;
        } else {
//            't is nie gelukt
        }
    }

    public int getMana(){
        if (turn < maxMana){
            return turn;
        } else {
            return maxMana;
        }
    }

    private Player getCurrentPlayer(){
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
}
