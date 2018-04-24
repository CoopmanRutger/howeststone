package heroes;

public class HeroPower {
    private int damage;
    private int manaCost;

    public HeroPower(int damage, int manaCost) {
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }
}
