package playField.cardCollection.cards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class CardSpell extends Card{
	
    @JsonProperty("mechanicsName")
    private String mechanicsName;
    @JsonProperty("abilities")
    private Set<CardSpellAbilities> abilities;

    public CardSpell(@JsonProperty("cardId") String cardId,
                     @JsonProperty("name") String name,
                     @JsonProperty("type") String type,
                     @JsonProperty("mana") int mana,
                     @JsonProperty("heroType") String heroType,
                     @JsonProperty("description") String description,
                     @JsonProperty("img") String img,
					 @JsonProperty("mechanicsName") String mechanicsName,
                     @JsonProperty("abilities") Set<CardSpellAbilities> abilities
    ) {
        super(cardId, name, type, mana, heroType, description, img);
        this.mechanicsName = mechanicsName;
    }

    public void play() {

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
