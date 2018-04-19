package Cards;

public class CardMinion extends Card{
    private int health;

    public CardMinion(String cardId, int attack, String name, String img, String type, int health) {
        super(cardId, attack, name, img, type);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
