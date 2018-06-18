package cards;

import org.junit.Before;
import org.junit.Test;
import playfield.cardCollection.cards.CardWeapon;

import static org.junit.Assert.*;

public class CardWeaponTest {

    private CardWeapon test;

    @Before
    public  void before(){
        test = new CardWeapon("id01","name", "blue", 25, "blueGuy", "i am a faggot", "muh image",41, 20);

    }

    @Test
    public void blbala(){
        System.out.println(test.getClass());
        assertEquals("class playField.cardCollection.cards.CardWeapon",test.getClass().toString());
    }

}