package ru.jjd.base.examfarm;

public class WildAnimal extends Animal implements CanAttack{
    private int strength;
    private int tryCount;

    public WildAnimal(String name, int weight, int speed, int strength) {
        super(name, weight, speed);
        setStrength(strength);
        tryCount = 0;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength >= 0) {
            this.strength = strength;
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    public void beDrivedAway(){
        tryCount++;
    }

    @Override
    public void attack(CanBeAttacked animal) {
        if (tryCount < 4) {
            animal.beAttacked(this);
        }
    }
}
