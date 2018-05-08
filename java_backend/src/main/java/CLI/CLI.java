package CLI;

import playField.PlayingField;
import player.Player;

public class CLI {

    public static void main(String[] args) {
        new CLI().run();
    }

    private void run() {
        Player p = new Player();

        PlayingField pf = new PlayingField();
    }
}
