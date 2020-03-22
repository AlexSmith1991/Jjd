package ru.jjd.base.animals;

public class main {
    //есть три класса мышь, кот и волк, и два интерфейса может съесть и может быть съеден
    //интерфейс тоже может использоваться как тип данных
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        Cat cat = new Cat();
        Wolf wolf = new Wolf();
        cat.beEaten(wolf);
    }
}
