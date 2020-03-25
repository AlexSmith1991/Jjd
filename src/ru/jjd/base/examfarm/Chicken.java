package ru.jjd.base.examfarm;

public class Chicken extends HomeAnimal {
    public Chicken(String name, int weight, int speed, int health, int resource) {
        super("Chicken " + name, weight, speed, health, resource, true);
    }
}
