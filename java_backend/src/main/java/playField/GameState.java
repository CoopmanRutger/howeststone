package playField;

import playField.cardCollection.Deck;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;
import playField.player.Player;

public abstract class GameState extends Game {
    public Deck deck;

    public HeroPower heroPower;
    public Hero hero;

    public Player p;
    public Player o;

    public boolean begins;

    public PlayingField pf;
}
