package playField;

import cardCollection.Deck;
import heroes.Hero;
import heroes.HeroPower;
import playField.PlayingField;
import player.Player;

public class GameState {
    public Deck deck;

    public HeroPower heroPower;
    public Hero hero;

    public Player p;
    public Player o;

    public boolean begins;

    public PlayingField pf;
}
