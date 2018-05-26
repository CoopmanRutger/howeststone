package playfield.player.heroes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Hero {
    @JsonProperty("name")
    private String name;
    @JsonProperty("img")
    private String img;
    @JsonProperty("heroPower")
    private HeroPower heroPower;
    @JsonProperty("lifePoints")
    private int lifePoints = 30;
    @JsonProperty("armourPoints")
    private int armourPoints = 0;
    @JsonCreator
    public Hero(@JsonProperty("name") String name, @JsonProperty("img") String img,
                @JsonProperty("heroPower") HeroPower heroPower) {
        this.name = name;
        this.img = img;
        this.heroPower = heroPower;
    }

    // DAMGE AND LIFE FUNCTIONS

    public void takeDamage(int damageHit) {
        if (armourPoints <= 0) {
            lifePoints -= damageHit;
        } else if (armourPoints > damageHit) {
            armourPoints -= damageHit;
        } else if (armourPoints < damageHit) {
            damageHit -= armourPoints;
            armourPoints = 0;
            lifePoints -= damageHit;
        }
    }




    public boolean isAlive() {
        return lifePoints > 0;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void incrHealth(int amount) {
        lifePoints += amount;
    }

    public void incrArmour(int amount) {
        armourPoints += amount;
    }

    // GETTERS AND SETTERS

    public int getAmourPoints() {
        return armourPoints;
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
        return name + ":\thealth: " + lifePoints + ",\theroPower: " + heroPower + "\tarmour: " + armourPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Hero hero = (Hero) o;
        return lifePoints == hero.lifePoints
                && armourPoints == hero.armourPoints
                && Objects.equals(name, hero.name)
                && Objects.equals(img, hero.img)
                && Objects.equals(heroPower, hero.heroPower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, img, heroPower, lifePoints, armourPoints);
    }
}
