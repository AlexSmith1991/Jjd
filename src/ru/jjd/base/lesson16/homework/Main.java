package ru.jjd.base.lesson16.homework;

import ru.jjd.base.lesson14.hw.car.Car;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Car blackOpel = new Car("black", "opel", 2000);
        int[] arr = {1, 2, 3, 4, 5};
        Example example = new Example("Example", 1, blackOpel, arr);
        if (toString(example, 0)){

        }
    }

    private static boolean toString(Object o, int level) throws IllegalAccessException {
        Class oClass = o.getClass();
        if (oClass.isPrimitive() || oClass == String.class || oClass == Byte.class ||
                oClass == Short.class || oClass == Integer.class || oClass == Long.class ||
                oClass == Float.class || oClass == Double.class || oClass == Boolean.class ||
                oClass == Character.class) {
            return false;
        }
        Field[] oFields = oClass.getDeclaredFields();
        for (Field field: oFields){
            System.out.println();
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            field.setAccessible(true);
            System.out.print(field.getName() + " : ");
            if (!toString(field.get(o), level + 1)){
                System.out.print(field.get(o));
            }
        }
        return true;
    }
}

class Example{
    private String text;
    private int number;
    private int[] arr;
    private Car car;

    public Example(String text, int number, Car car, int[] arr) {
        this.text = text;
        this.number = number;
        this.arr = arr;
        this.car = car;
    }
}
