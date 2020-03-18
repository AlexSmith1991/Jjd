package ru.jjd.base.lesson7;

public class King extends Unit{
    private int gold;

    public King(int healthScore, int speed, int gold) {
        super(healthScore, speed);
        setGold(gold);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public void rest() {
        System.out.println("Король отдыхает");
    }
}
