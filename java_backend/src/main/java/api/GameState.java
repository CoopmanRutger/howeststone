package api;

import cardCollection.Deck;
import heroes.Hero;
import heroes.HeroPower;
import playField.PlayingField;
import player.Player;

public class GameState {
    Deck deck;

    HeroPower heroPower;
    Hero hero;

    Player p;
    Player o;

    boolean begins;

    PlayingField pf;
}
