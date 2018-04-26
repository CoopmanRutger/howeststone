package cards;

import java.util.Objects;

public class Card {
    private String cardId;
    private String name;
    private String img;
    private String type; // minion - spell - weapon
    private String heroType;

    public Card(String cardId, String name, int attack,  String type, String heroType, String img) {
        this.cardId = cardId;
        this.name = name;
        this.img = img;
        this.type = type;
        this.heroType = heroType;
    }

    public String getHeroType() {
        return heroType;
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

    public String getType() {
        return type;
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
