package heroes;

public class HeroPower {
    private int damage;
    private int manaCost;
    private boolean heroPowerActive;

    public HeroPower(int damage, int manaCost, boolean heroPowerActive) {
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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}
