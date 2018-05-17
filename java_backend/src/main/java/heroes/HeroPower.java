package heroes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HeroPower {
    @JsonProperty("Damage")
    private int damage;
    @JsonProperty("Cost of mana")
    private int manaCost;
    @JsonProperty("Hero power active: ")
    private boolean heroPowerActive;

    @JsonCreator
    public HeroPower(@JsonProperty("Damage") int damage,
                     @JsonProperty("Cost of mana") int manaCost,
                     @JsonProperty("Hero power active:") boolean heroPowerActive) {
        this.damage = damage;
        this.manaCost = manaCost;
        this.heroPowerActive = heroPowerActive;
    }



    public int jusheroPower(){

        // TODO : wat gebeurt er als je op heropower klikt

        setHeroPowerActive(false);
        return -1;
    }



    public int getDamage() {
        return damage;
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

//    public void setDamage(int damage) {
//        this.damage = damage;
//    }
//
//    public void setManaCost(int manaCost) {
//        this.manaCost = manaCost;
//    }
}
