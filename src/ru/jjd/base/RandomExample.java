package ru.jjd.base;

import java.util.Date;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random random1 = new Random();
        Random random2 = new Random(new Date().getTime());

        //методы
        System.out.println(random2.nextBoolean());
        System.out.println(random2.nextInt());
        System.out.println(random2.nextInt(34));//[0,max) 34 в рандом не включается

        System.out.println(random2.nextFloat());
        System.out.println(random2.nextDouble());

        //[10;100]
        int min = 10;
        int max = 100;
        int diff = max - min;
        int randomNum = random2.nextInt(diff + 1) + min;

    }
}
