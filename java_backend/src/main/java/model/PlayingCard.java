package model;

public class PlayingCard {
    private String name;
    private int attack;

    public PlayingCard(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }
}
