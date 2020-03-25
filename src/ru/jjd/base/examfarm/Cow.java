package ru.jjd.base.examfarm;

public class Cow extends HomeAnimal {
    public Cow(String name, int weight, int speed, int health, int resource) {
        super("Cow" + name, weight, speed, health, resource, true);
    }
}
