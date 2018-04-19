package model;

public class CardSpell extends Card{
    //Declaratie van field
   private int type;

    // Bij de initialisatie van de classe verwacht de constructor de volgende variabelen, die worden opgevraagd vanuit de superclasse Cards
    public CardSpell(String cardId, int attack, String name, String img) {
        super(cardId, attack, name, img);
    }
    // Accesoren
    public String getCardId() {
        return cardId;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getImg() {
        return img;
    }
    //mutators
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card cardSpell = (CardSpell) o;
        return Objects.equals(cardId, cardSpell.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId);
    }
}
}