package ru.jjd.base.examfarm;

public class Animal {
    private String name;
    private int weight;
    private int speed;

    public Animal(String name, int weight, int speed) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null){
            this.name = name;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0){
            this.weight = weight;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed > 0){
            this.speed = speed;
        }
    }
}
