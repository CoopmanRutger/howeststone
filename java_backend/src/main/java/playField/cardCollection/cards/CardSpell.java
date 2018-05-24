package playField.cardCollection.cards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class CardSpell extends Card{
	
    @JsonProperty("mechanicsName")
    private String mechanicsName;
    @JsonProperty("armourToGive")
    private int armourToGive;
    @JsonProperty("amountToAttack")
    private Set<CardAbility> abilities;
    @JsonProperty("healthToGive")
    private int healthToGive;
    @JsonProperty("attackToGive")
    private int attackToGive;
    @JsonProperty("spellDamage")
    private int spellDamage;

    public CardSpell(@JsonProperty("cardId") String cardId,
                     @JsonProperty("name") String name,
                     @JsonProperty("type") String type,
                     @JsonProperty("mana") int mana,
                     @JsonProperty("heroType") String heroType,
                     @JsonProperty("description") String description,
                     @JsonProperty("img") String img,
					 @JsonProperty("mechanicsName") String mechanicsName,
                     @JsonProperty("abilities") Set<CardAbility> abilities,
                     @JsonProperty("amountToAttack") int amountToAttack,
                     @JsonProperty("healthToGive") int healthToGive,
                     @JsonProperty("armourToGive") int armourToGive,
                     @JsonProperty("attackToGive") int attackToGive,
                     @JsonProperty("spellDamage") int spellDamage
    ) {
        super(cardId, name, type, mana, heroType, description, img);
        this.mechanicsName = mechanicsName;
        this.abilities = abilities;
        this.spellDamage=spellDamage;
        this.armourToGive=armourToGive;
        this.attackToGive=attackToGive;
    }
    

    @Override
    public String identifier(){
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

    public int getSpellDamage() { return spellDamage; }
}
