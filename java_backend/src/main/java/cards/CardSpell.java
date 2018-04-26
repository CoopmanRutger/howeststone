package cards;

public class CardSpell extends Card{

    private String mechanicsName;

    public CardSpell(String cardId, String name, String type, int mana, String heroType, String description, String img, String mechanicsName) {
        super(cardId, name, type, mana, heroType, description, img);
        this.mechanicsName = mechanicsName;
    }

    public String getMechanicsName() {
        return mechanicsName;
    }

    @Override
    public String toString() {
        return "CardSpell{" +
                "mechanicsName='" + mechanicsName + '\'' +
                '}';
    }
}
