package cards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardWeapon extends Card {

		@JsonProperty("attack")
		private int attack;
		@JsonProperty("durability")
		private int durability;
//    private boolean heroWeaponActive;

    public CardWeapon(String cardId, String name, String type, int mana, String heroType, String description, String img, int attack, int durability) {
        super(cardId, name, type, mana, heroType, description, img);
        this.attack = attack;
        this.durability = durability;
    }

    public int getAttack() {
        return attack;
    }

    public int getDurability() {
        return durability;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "CardWeapon " +
                super.toString() +
                "attack: " + attack +
                ", durability: " + durability + "\n";
    }
}
