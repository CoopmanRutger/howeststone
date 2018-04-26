package cards;

public class CardWeapon extends Card {

    private int durability;

    public CardWeapon(String cardId, int attack, String name, String img, String type, String heroType, int durability) {
        super(cardId, attack, name, img, type, heroType);
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
