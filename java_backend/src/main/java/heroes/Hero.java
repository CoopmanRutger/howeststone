package heroes;

public class Hero {

    private String name;
    private String img;
    private HeroPower heroPower;

    public Hero(String name, String img, HeroPower heroPower) {
        this.name = name;
        this.img = img;
        this.heroPower = heroPower;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setHeroPower(HeroPower heroPower) {
        this.heroPower = heroPower;
    }
}
