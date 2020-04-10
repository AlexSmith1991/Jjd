package ru.jjd.base.fitness;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Gym gym = new Gym();
        while (LocalTime.now().isAfter(LocalTime.of(8,0)) &&
                LocalTime.now().isBefore(LocalTime.of(22, 0))) {
            System.out.println("1 - Добавить посещение");
            System.out.println("2 - Посмотреть текуий состав групп");
            System.out.println("3 - Выход");
            int number = in.nextInt();
            switch (number){
                case 1:
                    gym.visit(null);
                    break;
                case 2:
                    gym.displayGuests();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
        gym.NewDay();
        return;
    }
}
