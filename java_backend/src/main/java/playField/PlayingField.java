package playField;

import playField.player.Player;

import java.util.Random;

public class PlayingField {
    private Player player;
    private Player opponent;

    private int index = 2; // for your turn (you are for example 1, adversary = 0)
    private int curMana;
    private boolean begins;
    private static final int maxMana = 10;

    // CONSTRUCTOR

    public PlayingField(Player player, Player opponent) {
        Random r = new Random();
        begins = r.nextInt(2) == 0;

        this.player = player;
        this.opponent = opponent;

        for (int i = 0; i < 3; i++) {
            player.drawCard();
            opponent.drawCard();
        }

        curMana = calculateMana();
    }

    // GETTERS

    public Player getPlayer() {
        return player;
    }

    public Player getOpponent() {
        return opponent;
    }

    // GETTING THE RIGHT PLAYER

    private int getPlayerIndex(){
        if (begins) return 0;
        else return 1;
    }

    public Player getCurrentPlayer() {
        if (index % 2 == getPlayerIndex()) return player;
        else return opponent;
    }

    public Player getOppositePlayer() {
        if (index % 2 != getPlayerIndex()) return player;
        else return opponent;
    }

    public boolean isOpponent () {
        return getPlayerIndex() != (index % 2);
    }

    // TURN AND INCREMENT

    private int getTurn(){
        return index/2;
    }

    public void increment() {
        index++;
        curMana = calculateMana();
    }

    // MANA FUNCTIONS

    public int calculateMana() {
        int turn = getTurn();
        if (turn < maxMana) return turn;
        else return maxMana;
    }

    public int getCurMana() {
        return curMana;
    }

    public void decrMana(int amount){
        curMana -= amount;
    }

    // UTILITY

    public void playCard(String id){
        Player curPlayer = getCurrentPlayer();

        int mana = curPlayer.getManaFromId(id);

        if ((mana != -1) && (mana <= curMana)) curPlayer.playCard(id);
        curMana -= mana;
    }

    @Override
    public String toString() {
        return "doesn't yet have a toString()";
    }
}
