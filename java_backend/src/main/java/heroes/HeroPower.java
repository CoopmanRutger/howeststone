package heroes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HeroPower {

    @JsonProperty("heroPowerName")
    private String heroPowerName;

    @JsonProperty("manaCost")
    private int manaCost;

    @JsonProperty("tags")
    private String tags;

    @JsonProperty("abilityType")
    private String abilityType;

    @JsonProperty("abilityValue")
    private int abilityValue;

    @JsonProperty("duration")
    private int duration;

    @JsonProperty("img")
    private String img;

    public HeroPower(String heroPowerName, int manaCost, String tags, String abilityType, int abilityValue, int duration, String img, boolean heroPowerActive) {
        this.heroPowerName = heroPowerName;
        this.manaCost = manaCost;
        this.tags = tags;
        this.abilityType = abilityType;
        this.abilityValue = abilityValue;
        this.duration = duration;
        this.img = img;
        this.heroPowerActive = heroPowerActive;
    }

    @JsonProperty("Hero power active: ")
    private boolean heroPowerActive;





    public int jusheroPower(){

        // TODO : wat gebeurt er als je op heropower klikt

        setHeroPowerActive(false);
        return -1;
    }



    public int getAbilityValue() {
        return abilityValue;
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
}
