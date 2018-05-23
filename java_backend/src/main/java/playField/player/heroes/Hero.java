package playField.player.heroes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Hero {
    @JsonProperty("name")
    private String name;
    @JsonProperty("img")
    private String img;
    @JsonProperty("hero power")
    private HeroPower heroPower;
    @JsonProperty("life points")
    private int lifePoints = 30;
    @JsonProperty("amour points")
    private int amourPoints = 0;

    @JsonCreator
    public Hero(@JsonProperty("name") String name, @JsonProperty("img") String img, @JsonProperty("heroPower") HeroPower heroPower) {
        this.name = name;
        this.img = img;
        this.heroPower = heroPower;
    }

    // DAMGE AND LIFE FUNCTIONS

    public void takeDamage(int damage){
        if (amourPoints <= 0){
             lifePoints -= damage;
        } else if (amourPoints > damage){
            amourPoints =- damage;
        } else if (amourPoints < damage){
            damage -= amourPoints;
            amourPoints = 0;
            lifePoints -= damage;
        }
    }

    public boolean isAlive() {
        return lifePoints > 0;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void incrArmour(int amount) {
        amourPoints += amount;
    }

    // GETTERS AND SETTERS

    public int getAmourPoints() {
        return amourPoints;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public HeroPower getHeroPower() {
        return heroPower;
    }

    // UTIL STUFF

    @Override
    public String toString() {
        return name + ":\thealth: " + lifePoints + ",\theroPower: " + heroPower + "\tarmour: " + amourPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return lifePoints == hero.lifePoints &&
                amourPoints == hero.amourPoints &&
                Objects.equals(name, hero.name) &&
                Objects.equals(img, hero.img) &&
                Objects.equals(heroPower, hero.heroPower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, img, heroPower, lifePoints, amourPoints);
    }
}
