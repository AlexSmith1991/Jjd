package ru.jjd.base.examfarm;

public class Rabbit extends HomeAnimal {
    public Rabbit(String name, int weight, int speed, int health) {
        super("Rabbit " + name, weight, speed, health, 0, true);
    }
}
