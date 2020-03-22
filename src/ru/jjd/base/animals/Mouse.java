package ru.jjd.base.animals;

public class Mouse implements CanBeEaten {


    @Override
    public void beEaten(CanEat animal) {
        System.out.println("Был съеден" + animal);
    }
}
