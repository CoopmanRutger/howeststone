package playField.cardCollection.cards;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Card {
    @JsonProperty("cardId")
    private String cardId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type; // minion - spell - weapon
    @JsonProperty("mana")
    private int mana;
    @JsonProperty("heroType")
    private String heroType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("img")
    private String img;
    @JsonProperty("age")
    private int age;

    @JsonCreator
    public Card(@JsonProperty("cardId") String cardId,
                @JsonProperty("name") String name,
                @JsonProperty("type") String type,
                @JsonProperty("mana") int mana,
                @JsonProperty("heroType") String heroType,
                @JsonProperty("description") String description,
                @JsonProperty("img") String img) {
        this.cardId = cardId;
        this.name = name;
        this.type = type;
        this.mana = mana;
        this.heroType = heroType;
        this.description = description;
        this.img = img;
        age = 0;
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
        return name + "\tcardId: " + cardId +
                ",\tmana: " + mana + ",\t";
    }

    public int getAttack() {
        return 0;
    }
}
