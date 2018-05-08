package playField;

import player.Bot;
import player.Player;

public class PlayingField {
    Player players[] = new Player[2];
    private int turn = 1;
    private final int maxMana = 10;
    private short index = 0;
    // Player CurrentPlayer;

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
}
