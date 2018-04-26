package cards;

public class CardWeapon extends Card {

    private int attack;
    private int durability;

    public CardWeapon(String cardId, String name, String type, int mana, String heroType, String description , String img) {
        super(cardId, name, type, mana, heroType, description, img);
    }

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

    @Override
    public String toString() {
        return "CardWeapon{" +
                "attack=" + attack +
                ", durability=" + durability +
                '}';
    }
}
