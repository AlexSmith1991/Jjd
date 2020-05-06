package ru.jjd.base.lesson14.hw.car;

import java.util.ArrayList;

public class ComparingExample {
    public static void main(String[] args) {
        // Дополнительное домашнее задание
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);

        // Объекты добавить в ArrayList cars

        // отсортировать объекты в cars сначала по brand, price, color
        // cars.sort(компаратор);

        ArrayList<Car> cars = new ArrayList<>(4);
        cars.add(blackOpel);
        cars.add(redOpel);
        cars.add(yellowMazda);
        cars.add(greenMazda);

        cars.sort(new CarBrandComparator().thenComparing(new CarPriceComparator()).thenComparing(new CarColorComparator()));

        for (Car car: cars){
            System.out.println(car.toString());
        }


    }
}
