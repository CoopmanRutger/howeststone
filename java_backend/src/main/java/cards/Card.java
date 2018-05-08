package cards;

import java.util.Objects;

public class Card {
    private String cardId;
    private String name;
    private String type; // minion - spell - weapon
    private int mana;
    private String heroType;
    private String description;
    private String img;

    public Card(String cardId, String name, String type, int mana, String heroType, String description, String img) {
        this.cardId = cardId;
        this.name = name;
        this.type = type;
        this.mana = mana;
        this.heroType = heroType;
        this.description = description;
        this.img = img;
    }

    public String getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getMana() {
        return mana;
    }

    public String getHeroType() {
        return heroType;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMana(int mana) { this.mana = mana;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "cardId: " + cardId +
                ", name: " + name +
                ", mana: " + mana + " ";
    }
}
