package playfield.cardCollection.cards;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardWeapon extends Card {
    @JsonProperty("attack")
    private int attack;
    @JsonProperty("durability")
    private int durability;
    //private boolean heroWeaponActive;


    @JsonCreator
    public CardWeapon(@JsonProperty("cardId") String cardId,
                      @JsonProperty("name")String name,
                      @JsonProperty("type")String type,
                      @JsonProperty("mana")int mana,
                      @JsonProperty("heroType")String heroType,
                      @JsonProperty("description")String description,
                      @JsonProperty("image")String img,
                      @JsonProperty("attack")int attack,
                      @JsonProperty("durability")int durability) {
        super(cardId, name, type, mana, heroType, description, img);
        this.attack = attack;
        this.durability = durability;
    }

    @Override
    public String identifier() {
        return "CardWeapon";
    }

    public int defaultAttack() {
        attack = 15;
        return attack;
    }

    public int getAttack() {
        return attack;
    }

    public int getDurability() {
        return durability;
    }

    public void setAttack(int attack) {
        if (durability > 0) {
            this.attack = attack;
        } else if (durability == 0) {
            setAttack(0);
        }
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "CardWeapon "
                + super.toString()
                + "attack: " + attack
                + ", durability: " + durability + "\n";
    }
}
