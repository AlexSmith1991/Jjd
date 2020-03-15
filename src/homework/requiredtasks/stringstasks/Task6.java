package homework.requiredtasks.stringstasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
/*
*Переставить названия городов в алфавитном порядке
*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите города через пробел");
        String citiesString = in.nextLine();
        citiesString = citiesString.trim();
        String[] cities = citiesString.split("\\s");
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].replaceAll("\\W", "");
        }
        Arrays.sort(cities);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cities.length; i++) {
            sb.append(cities[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
