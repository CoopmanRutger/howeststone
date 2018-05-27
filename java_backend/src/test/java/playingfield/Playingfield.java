package playingfield;

import playField.cardCollection.Deck;
import playField.cardCollection.cards.CardAbility;
import playField.cardCollection.cards.CardMinion;
import org.junit.Before;
import org.junit.Test;
import playField.player.Player;
import playField.PlayingField;
import playField.player.heroes.AbilityType;
import playField.player.heroes.Hero;
import playField.player.heroes.HeroPower;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class Playingfield {

    private Player player;
    private PlayingField testField;

    @Before
    public void hmm() {
        final Deck deck = new Deck();
        for (int i = 0; i < 30; i++) {
            deck.addCard(
                    new CardMinion("ID" + 2 + i,
                    "",
                    "name",
                    1,
                    "",
                    "heroType",
                    "0", 3,
                    0,
                    "asian",
                    "lol",
                    new HashSet<CardAbility>()
                    )
            );
        }

        final HeroPower heroPower = new HeroPower("",
                0,
                "",
                AbilityType.heal,
                0,
                0,
                "",
                true
        );
        final Hero hero = new Hero("mage", "im", heroPower);

        player = new Player(deck, hero);
        final Player opponent = new Player(deck, hero);

        testField = new PlayingField(player, opponent);
        // TODO minion met 3 mana kan niet gespeeld worden als je maar 2 mana hebt.
        // TODO als je 5 mana heb en je speelt een kaart van 2 mana, erna nog een kaart van 2, heb je nog 1 mana over.
        // TODO als end turn is true kan de speler niets doen.
        // TODO als end turn is false kan je wel bepaalde dingen doen.
        // TODO (vodoo docter) als minion 1 leven af is en je hersteld met 2 levens krijgt hij toch maar 1 leven bij.
        // TODO minion wordt aangevallen en heeft < 0 levens dus wordt van veld verwijderd.

    }

    @Test
    public void checkIfItsYourTurn() {
        assertEquals(1, testField.getCurMana());
        for (int i = 0; i < 4; i++) {
            testField.increment();
            //opponent speelt
            testField.increment();
            //turn 2-5
        }
        assertEquals(5, testField.getCurMana());
    }

    @Test
    public void heroStartGame() {
        assertEquals(30, player.getHero().getLifePoints());
        assertEquals(0, player.getHero().getAmourPoints());
    }

    @Test
    public void heroGetsAmour() {
        player.getHero();
        assertEquals(5, player.getHero().getAmourPoints());
    }


}
