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

    public void setMechanicsName(String mechanicsName) {
        this.mechanicsName = mechanicsName;
    }

    @Override
    public String toString() {
        return "CardSpell " +
                super.toString() +
                "mechanicsName: " + mechanicsName + "\n";
    }
}
