package cards;

public class CardWeapon extends Card{

    private int durability;

    public CardWeapon(String cardId, int attack, String name, String img, int durability, String type) {
        super(cardId, attack, name, img, type);
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
