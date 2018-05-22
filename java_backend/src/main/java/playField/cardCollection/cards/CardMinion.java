package playField.cardCollection.cards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

import static playField.cardCollection.cards.CardMinionAbility.*;

public class CardMinion extends Card{
    @JsonProperty("attack")
    private int attack;
    @JsonProperty("health")
    private int health;
    @JsonProperty("race")
    private String race;
    @JsonProperty("mechanicsName")
    private String mechanicsName;
    @JsonProperty("abilities")
    private Set<CardMinionAbility> abilities;
    @JsonProperty("maxAmountAttack")
    private int maxAmountAttack = 1;
    @JsonProperty("amountAttack")
    private int amountAttack = 1;

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
                      @JsonProperty("mechanicsName") String mechanicsName,
                      @JsonProperty("abilities") Set<CardMinionAbility> abilities
                      ) {
        super(cardId, name, type, mana, heroType, description, img);
        this.attack = attack;
        this.health = health;
        this.race = race;
        this.mechanicsName = mechanicsName;
        if (abilities.contains(charge)) amountAttack = 0;
        if (abilities.contains(windFury)) maxAmountAttack = 2;
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
        return super.toString() +
                "\tattack: " + attack +
                "\thealth: " + health +
                "\tcanPlay:" + getCanAttack() +
                "\tmechanicsName:" + mechanicsName + "\n";
    }

    public boolean getCanAttack() {
        return amountAttack < maxAmountAttack;
    }

    public void incrCanAttack(boolean canAttack) {
        amountAttack++;
    }

    public void resetCanAttack(boolean canAttack) {
        amountAttack = 0;
    }
}
