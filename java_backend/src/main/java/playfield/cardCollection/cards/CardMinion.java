package playfield.cardCollection.cards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

import static playfield.cardCollection.cards.CardAbility.*;



public class CardMinion extends Card {
    @JsonProperty("attack")
    private int attack;
    @JsonProperty("health")
    private int health;
    @JsonProperty("maxHealth")
    private int maxHealth;
    @JsonProperty("race")
    private String race;
    @JsonProperty("mechanicsName")
    private String mechanicsName;
    @JsonProperty("abilities")
    private Set<CardAbility> abilities;
    @JsonProperty("maxAmountAttack")
    private int maxAmountAttack = 1;
    @JsonProperty("amountAttacked")
    private int amountAttacked = 1;
    @JsonProperty("devineShield")
    private boolean devineShield;


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
                      @JsonProperty("abilities") Set<CardAbility> abilities
                      ) {
        super(cardId, name, type, mana, heroType, description, img);
        this.attack = attack;
        this.health = health;
        this.maxHealth = health;
        this.race = race;
        this.mechanicsName = mechanicsName;
        if (abilities.contains(charge)) {
            amountAttacked = 0;
        }
        if (abilities.contains(windFury)) {
            maxAmountAttack = 2;
        }
        devineShield = false;
        if (abilities.contains(divineShield)) {
            devineShield = true;
        }
    }

    @Override
    public String identifier() {
        return "CardMinion";
    }

    // TAKE DAMAGE FUNCTION

    public void takeDamage(int damage) {
        if (devineShield) {
            devineShield = false;
        } else {
            health -= damage;
        }
    }

    // HEAL MOTHAFUCKAAA

    public void heal(int amount) {
        health += amount;
        if (maxHealth < health) {
            health = maxHealth;
        }
    }

    // UTIL
    public boolean isAlive() {
        return health > 0;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }
//
//    public String getRace() {
//        return race;
//    }
//
//    public String getMechanicsName() {
//        return mechanicsName;
//    }
//
//    public void setAttack(int attack) {
//        this.attack = attack;
//    }
//
//    public void setHealth(int health) {
//        this.health = health;
//    }
//
//    public void setRace(String race) {
//        this.race = race;
//    }
//
//    public void setMechanicsName(String mechanicsName) {
//        this.mechanicsName = mechanicsName;
//    }

    public void incrAttack(int amount) {
        amountAttacked += amount;
        maxAmountAttack += amount;
    }

    public boolean getCanAttack() {
        return amountAttacked < maxAmountAttack;
    }

    public void incrCanAttack() {
        amountAttacked++;
    }

    public void resetCanAttack() {
        amountAttacked = 0;
    }

    public void incrHealth(int healAmount) {
        maxHealth += healAmount;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\tattack: " + attack
                + "\thealth: " + health
                + "\tcanPlay:" + getCanAttack()
                + "\tmechanicsName:" + mechanicsName + "\n";
    }
}
