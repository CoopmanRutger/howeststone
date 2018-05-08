package playField;

import player.Bot;
import player.Player;

public class PlayingField {
    Player players[] = new Player[2];
    Bot opponent;
    Player player;
    private int turn = 1;
    private final int maxMana = 10;
    private short index = 0;
  //*  Player CurrentPlayer;

    
    public Player selectNextPlayer() {
        index++;
        index %= 2;
        return players[index];
    }
}
