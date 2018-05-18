package playField;

import cardCollection.Cards;
import cards.Card;
import cards.CardMinion;
import player.Player;

import java.util.Random;

public class PlayingField {
    // TODO: 18/05/2018 mischien gewoon apparte velden maken
    // TODO: 18/05/2018 abstractie
    private Player player;
    private Player opponent;

    private static final int maxMana = 10;
    private int mana;
    private int index = 2; // for your turn (you are for example 1, adversary = 0)
    private boolean begins;

    public PlayingField(Player player, Player opponent) {
        Random r = new Random();
        begins = r.nextInt(2) == 0;

        this.begins = begins;

        this.player = player;
        this.opponent = opponent;

        for (int i = 0; i < 3; i++) {
            player.drawCard();
            opponent.drawCard();
        }
    }

    public int minionAttack(CardMinion card){
        return  card.getAttack();
    }

    public void increment() {
        index++;
        mana = calculateMana();
    }

    public int calculateMana() {
        int turn = getTurn();
        if (turn < maxMana) return turn;
        else return maxMana;
    }

    public int getMana() {
        return mana;
    }



    private int getPlayerIndex(){
        int playerIndex;

        if (begins) playerIndex = 0;
        else playerIndex = 1;

        return playerIndex;
    }

    public Player getCurrentPlayer() {
        if (index % 2 == getPlayerIndex()) return player;
        else return opponent;
    }

    private int getTurn(){
        return index/2;
    }



    public boolean isOpponent () {
        return getPlayerIndex() != (index % 2);
    }

    public void playCard(String id){
        Player curPlayer = getCurrentPlayer();
        int curMana = player.getManaFromId(id);
        if (curMana <= mana) player.playCard(id);
    }



    @Override
    public String toString() {
        return "doesn't yet have a toString()";
    }

    public Player getPlayer() {
        return player;
    }

    public Player getOpponent() {
        return opponent;
    }
}
