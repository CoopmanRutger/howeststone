package heroes;

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
private boolean alive = true;

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

        if (getLifePoints() <= 0){
            setAlive(false);
        }
    }


    @JsonCreator
    public Hero(@JsonProperty("name") String name, @JsonProperty("img") String img, @JsonProperty("heroPower") HeroPower heroPower) {
        this.name = name;
        this.img = img;
        this.heroPower = heroPower;
    }
    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setAmourPoints(int amourPoints) {
        this.amourPoints = amourPoints;
    }

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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setHeroPower(HeroPower heroPower) {
        this.heroPower = heroPower;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", heroPower=" + heroPower +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return lifePoints == hero.lifePoints &&
                amourPoints == hero.amourPoints &&
                alive == hero.alive &&
                Objects.equals(name, hero.name) &&
                Objects.equals(img, hero.img) &&
                Objects.equals(heroPower, hero.heroPower);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, img, heroPower, lifePoints, amourPoints, alive);
    }
}
