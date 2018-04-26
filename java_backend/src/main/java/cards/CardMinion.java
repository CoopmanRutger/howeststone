package cards;

public class CardMinion extends Card{
    private int attack;
    private int health;
    private String race;
    private String mechanicsName;


    public CardMinion(String cardId, String name, String type, int mana, String heroType, String description, String img, int attack, int health, String race, String mechanicsName) {
        super(cardId, name, type, mana, heroType, description, img);
        this.attack = attack;
        this.health = health;
        this.race = race;
        this.mechanicsName = mechanicsName;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public String getRace() {
        return race;
    }

    public String getMechanicsName() {
        return mechanicsName;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setMechanicsName(String mechanicsName) {
        this.mechanicsName = mechanicsName;
    }
}
