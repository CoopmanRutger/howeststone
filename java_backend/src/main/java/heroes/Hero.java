package heroes;

public class Hero {

    private String name;
    private String img;
    private HeroPower heroPower;
    private int lifePoints = 30;
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


    public Hero(String name, String img, HeroPower heroPower) {
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
    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public HeroPower getHeroPower() {
        return heroPower;
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

    public int getAmourPoints() {
        return amourPoints;
    }

    public boolean isAlive() {
        return alive;
    }
}
