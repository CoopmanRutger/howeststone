package model;

public class CardWeaponcard extends Card{

    private int durability;
    private String type;

    public CardWeaponcard(String cardId, int attack, String name, String img, int durability, String type) {
        super(cardId, attack, name, img);
        this.durability = durability;
        this.type = type;
    }
}
