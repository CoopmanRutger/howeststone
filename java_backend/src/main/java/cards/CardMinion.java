package cards;

public class CardMinion extends Card{
    private int health;

    public CardMinion(String cardId, String name, int attack,  String type, String heroType, String img ,int health) {
        super(cardId, name, attack, type, heroType, img);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
