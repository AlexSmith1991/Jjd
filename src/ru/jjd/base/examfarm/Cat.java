package ru.jjd.base.examfarm;

public class Cat extends HomeAnimal {
    public Cat(String name, int weight, int speed, int health) {
        super("Cat " + name, weight, speed, health, 0, false);
    }
}
