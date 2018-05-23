package playField.player.heroes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class HeroPower {

    @JsonProperty("heroPowerName")
    private String heroPowerName;

    @JsonProperty("manaCost")
    private int manaCost;

    @JsonProperty("tags")
    private String tags;

    @JsonProperty("AbilityType")
    @JsonProperty("abilityType")
    private final AbilityType abilityType;

    @JsonProperty("abilityValue")
    private int abilityValue;

    @JsonProperty("duration")
    private int duration;

    @JsonProperty("img")
    private String img;

    @JsonProperty("heroPowerActive") // TODO: 21/05/2018 ???
    private boolean heroPowerActive;

    @JsonCreator
    public HeroPower(@JsonProperty("heroPowerName") String heroPowerName,
                     @JsonProperty("manaCost") int manaCost,
                     @JsonProperty("tags") String tags,
                     @JsonProperty("AbilityType") AbilityType abilityType,
                     @JsonProperty("abilityType") AbilityType abilityType,
                     @JsonProperty("abilityValue") int abilityValue,
                     @JsonProperty("duration") int duration,
                     @JsonProperty("img") String img,
                     @JsonProperty("heroPowerActive") boolean heroPowerActive
    ) {
        this.heroPowerName = heroPowerName;
        this.manaCost = manaCost;
        this.tags = tags;
        this.abilityType = abilityType;
        this.abilityValue = abilityValue;
        this.duration = duration;
        this.img = img;
        this.heroPowerActive = heroPowerActive;
    }


    public void jusheroPower(){

        // TODO : wat gebeurt er als je op heropower klikt

        setHeroPowerActive(false);
    }



    public int getAbilityValue() {
        return abilityValue;
    }

    public AbilityType getAbilityType() {
        return abilityType;
    }

    public int getManaCost() {
        return manaCost;
    }

    public boolean isHeroPowerActive() {
        return heroPowerActive;
    }

    public void setHeroPowerActive(boolean heroPowerActive) {
        this.heroPowerActive = heroPowerActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroPower heroPower = (HeroPower) o;
        return manaCost == heroPower.manaCost &&
                abilityValue == heroPower.abilityValue &&
                duration == heroPower.duration &&
                heroPowerActive == heroPower.heroPowerActive &&
                Objects.equals(heroPowerName, heroPower.heroPowerName) &&
                Objects.equals(tags, heroPower.tags) &&
                Objects.equals(abilityType, heroPower.abilityType) &&
                Objects.equals(img, heroPower.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroPowerName, manaCost, tags, abilityType, abilityValue, duration, img, heroPowerActive);
    }

    @Override
    public String toString() {
        return heroPowerName +
                ",\tcost: " + manaCost +
                ",\tAbilityType: " + abilityType +
                ",\tabilityValue: " + abilityValue +
                ",\ttags: " + tags +
                ",\tduration: " + duration +
                ",\tactive: " + heroPowerActive;
    }
}
