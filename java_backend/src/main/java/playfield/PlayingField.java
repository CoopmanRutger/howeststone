package playfield;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import playfield.player.Player;

import java.util.Random;

public class PlayingField {

    private static final int MAX_MANA = 10;
    @JsonProperty("player")
    private Player player;
    @JsonProperty("opponent")
    private Player opponent;

    // for your turn (you are for example 1, adversary = 0)
    private int index = 2;
    @JsonProperty("curMana")
    private int curMana;
    private boolean begins;

    // CONSTRUCTOR

    public PlayingField(Player player, Player opponent) {
//        Random r = new Random();
//        begins = r.nextInt(2) == 0;
        begins = true;
        this.player = player;
        this.opponent = opponent;

        for (int i = 0; i < 3; i++) {
            player.drawCard();
            opponent.drawCard();
        }
        curMana = calculateMana();;
    }

    // GETTERS
    public Player getPlayer() {
        return player;
    }

    public Player getOpponent() {
        return opponent;
    }

    // GETTING THE RIGHT PLAYER

    private int getPlayerIndex() {
        if (begins) {
            return 0;
        } else {
            return 1;
        }
    }

    @JsonIgnore
    public Player getCurrentPlayer() {
        if (index % 2 == getPlayerIndex()) {
            return player;
        } else {
            return opponent;
        }
    }

    @JsonIgnore
    public Player getOppositePlayer() {
        if (index % 2 != getPlayerIndex()) {
            return player;
        } else {
            return opponent;
        }
    }

    @JsonProperty("isOpponent")
    public boolean whosTurn() {
        if (getPlayerIndex() != (index % 2)) {
            return true;
        }
        return false;

    }

    // TURN AND INCREMENT

    private int getTurn() {
        return index / 2;
    }

    public void increment() {
        index++;
        curMana = calculateMana();
    }

    // MANA FUNCTIONS

    @JsonProperty("totalMana")
    public int calculateMana() {
        final int turn = getTurn();
        if (turn < MAX_MANA) {
            return turn;
        } else {
            return MAX_MANA;
        }
    }

    public int getCurMana() {
        return curMana;
    }

    public void decrMana(int amount) {
        curMana -= amount;
    }



    // TO STRING

    @Override
    public String toString() {
        return "Tegenspeler:\n" + getOppositePlayer().getCardsOnField().toString()
                + "Jezelf:\n" + getCurrentPlayer().getCardsOnField().toString()
                + "Je kaarten:\n" + getCurrentPlayer().getCardsInHand().toString();
    }
}
