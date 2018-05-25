package playField.cardCollection.cards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class CardSpell extends Card {

    @JsonProperty("mechanicsName")
    private String mechanicsName;
    @JsonProperty("armourToGive")
    private int armourToGive;
    @JsonProperty("abilities")
    private Set<CardAbility> abilities;
    @JsonProperty("healthToGive")
    private int healthToGive;
    @JsonProperty("attackToGive")
    private int attackToGive;
    @JsonProperty("spellDamage")
    private int spellDamage;

    @JsonProperty("doesDamage")
    private int doesDamage;
    @JsonProperty("doesHealth")
    private int doesHealth;
    @JsonProperty("damageTarget")
    private int damageTarget;
    @JsonProperty("healthTarget")
    private int healthTarget;
    @JsonProperty("drawCard")
    private boolean drawCard;
    @JsonProperty("amountOfDrawnCards")
    private int amountOfDrawnCards;
    @JsonProperty("onCondition")
    private boolean onCondition;
    @JsonProperty("conditionItSelf")
    private String conditionItSelf;
    @JsonProperty("destroy")
    private boolean destroy;


    public CardSpell(@JsonProperty("cardId") String cardId,
                     @JsonProperty("name") String name,
                     @JsonProperty("type") String type,
                     @JsonProperty("mana") int mana,
                     @JsonProperty("heroType") String heroType,
                     @JsonProperty("description") String description,
                     @JsonProperty("img") String img,
                     @JsonProperty("mechanicsName") String mechanicsName,
                     @JsonProperty("abilities") Set<CardAbility> abilities,
                     @JsonProperty("doesDamage") int doesDamage,
                     @JsonProperty("doesHealth") int doesHealth,
                     @JsonProperty("damageTarget") int damageTarget,
                     @JsonProperty("healthTarget") int healthTarget,
                     @JsonProperty("drawCard") boolean drawCard,
                     @JsonProperty("amountOfDrawnCards") int amountOfDrawnCards,
                     @JsonProperty("onCondition") boolean onCondition,
                     @JsonProperty("conditionItSelf") String conditionItSelf,
                     @JsonProperty("destroy") boolean destroy
                     @JsonProperty("amountToAttack") int amountToAttack,
                     @JsonProperty("healthToGive") int healthToGive,
                     @JsonProperty("armourToGive") int armourToGive,
                     @JsonProperty("attackToGive") int attackToGive,
                     @JsonProperty("spellDamage") int spellDamage
    ) {
        super(cardId, name, type, mana, heroType, description, img);
        this.mechanicsName = mechanicsName;
        this.abilities = abilities;
        this.doesDamage = doesDamage;
        this.doesHealth = doesHealth;
        this.damageTarget = damageTarget;
        this.healthTarget = healthTarget;
        this.drawCard = drawCard;
        this.amountOfDrawnCards = amountOfDrawnCards;
        this.onCondition = onCondition;
        this.conditionItSelf = conditionItSelf;
        this.destroy = destroy;
        this.spellDamage=spellDamage;
        this.armourToGive=armourToGive;
        this.attackToGive=attackToGive;
    }


    @Override
    public String identifier() {
        return "CardSpell";
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

    public Set<CardAbility> getAbilities() {
        return abilities;
    }

    public int getArmourToGive() {
        return armourToGive;
    }

    public int getHealthToGive() {
        return healthToGive;
    }

    public int getAttackToGive() {
        return attackToGive;
    }

    public int getDoesDamage() {
        return doesDamage;
    }

    public int getDoesHealth() {
        return doesHealth;
    }

    public int getDamageTarget() {
        return damageTarget;
    }

    public int getHealthTarget() {
        return healthTarget;
    }

    public boolean isDrawCard() {
        return drawCard;
    }

    public int getAmountOfDrawnCards() {
        return amountOfDrawnCards;
    }

    public boolean isOnCondition() {
        return onCondition;
    }

    public String getConditionItSelf() {
        return conditionItSelf;
    }

    public boolean isDestroy() {
        return destroy;
    }

    public int getSpellDamage() { return spellDamage; }
}
