package model;

import java.util.Objects;

public class Card {
    private String cardId;
    private int attack;
    private int health;
    private String name;
    private String img;

    public Card(String cardId, int attack, int health, String name, String img, String type, int durability) {
        this.cardId = cardId;
        this.attack = attack;
        this.health = health;
        this.name = name;
        this.img = img;
    }

    public String getCardId() {
        return cardId;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardId, card.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId);
    }
}
