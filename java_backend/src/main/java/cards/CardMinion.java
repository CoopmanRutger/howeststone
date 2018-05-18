package cards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardMinion extends Card{
    @JsonProperty("attack")
    private int attack;
    @JsonProperty("health")
    private int health;
    @JsonProperty("race")
    private String race;
    @JsonProperty("mechanicsName")
    private String mechanicsName;


    public CardMinion(@JsonProperty("cardId") String cardId,
                      @JsonProperty("name") String name,
                      @JsonProperty("type") String type,
                      @JsonProperty("mana") int mana,
                      @JsonProperty("heroType") String heroType,
                      @JsonProperty("description") String description,
                      @JsonProperty("img") String img,
                      @JsonProperty("attack") int attack,
                      @JsonProperty("health") int health,
                      @JsonProperty("race") String race,
                      @JsonProperty("mechanicsName") String mechanicsName) {

        super(cardId, name, type, mana, heroType, description, img);
        this.attack = attack;
        this.health = health;
        this.race = race;
        this.mechanicsName = mechanicsName;
    }


    public void takeDamage(int damage){
        health -= damage;
    }

    public boolean isAlive(){
        return health > 0;

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

    @Override
    public String toString() {
        return "CardMinion " +
                super.toString() +
                "attack: " + attack +
                ", health: " + health +
                ", race: " + race +
                ", mechanicsName:" + mechanicsName + "\n";
    }
}
