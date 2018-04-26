package cards;

public class CardMinion extends Card{
    private int attack;
    private int health;
    private String race;
    private String imgBack;
    private String mechanicsName;


    public CardMinion(String cardId, String name, String type, int mana, String heroType, String description, String img, int attack, int health, String race, String imgBack, String mechanicsName) {
        super(cardId, name, type, mana, heroType, description, img);
        this.attack = attack;
        this.health = health;
        this.race = race;
        this.imgBack = imgBack;
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

    public String getImgBack() {
        return imgBack;
    }

    public String getMechanicsName() {
        return mechanicsName;
    }
}
