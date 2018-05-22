package cards;

import org.junit.Before;
import org.junit.Test;
import playField.cardCollection.cards.CardWeapon;

import static org.junit.Assert.*;

public class CardWeaponTest {

    private CardWeapon test;

    @Before
    public  void before(){
        test = new CardWeapon("id01","name", "blue", 25, "blueGuy", "i am a faggot", "muh image",41, 20);
    }

    @Test
    public void defaultAttack(){
        assertEquals(15, test.defaultAttack());
    }

}