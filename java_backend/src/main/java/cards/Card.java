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
        return "Card{" +
                "cardId='" + cardId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", mana=" + mana +
                ", heroType='" + heroType + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
