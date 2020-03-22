package ru.jjd.base.animals;

public class Cat implements CanEat, CanBeEaten {


    @Override
    public void beEaten(CanEat animal) {
        System.out.println("Был съеден" + animal);
    }

    @Override
    public void eat(CanBeEaten animal) {
        System.out.println("Съел" + animal);
    }
}
