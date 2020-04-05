package ru.jjd.base.fitness;

import java.time.LocalDate;
import java.util.Scanner;

public class Gym {
    private GymPart pool;
    private GymPart training;
    private GymPart group;
    private Owner[] guests;
    private int guestscount;

    public Gym() {
        pool = new GymPart(true, false, true);
        training = new GymPart();
        group = new GymPart(false, true, true);
        guests = new Owner[500];
        guestscount = 0;
    }

    public void NewDay(){
        pool.NewDay();
        training.NewDay();
        group.NewDay();
    }

    private Owner getOwner(){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Создать нового посетителя");
            System.out.println("2 - Выбрать из существующих записей");
            int answer = in.nextInt();
            switch (answer){
                case 1:
                    System.out.println("Введите имя, фамилию и год рождения через пробел");
                    String ownerData = in.nextLine();
                    ownerData = ownerData.trim();
                    String[] ownerValues = ownerData.split("\\s");
                    if (ownerValues.length == 3){
                        ownerValues[0] = ownerValues[0].replaceAll("\\W", "");
                        ownerValues[1] = ownerValues[1].replaceAll("\\W", "");
                        ownerValues[2] = ownerValues[2].replaceAll("\\D", "");
                        int year = Integer.parseInt(ownerValues[2]);
                        Owner guest = new Owner(ownerValues[0], ownerValues[1], year);
                        if (guestscount < 500){
                            guests[guestscount++] = guest;
                        }
                        return guest;
                    }
                    break;
                case 2:
                    System.out.println("Введите номер посетителя");
                    for (int i = 0; i < guestscount; i++) {
                        System.out.print(i + 1);
                        System.out.println(": " + guests[i].toString());
                    }
                    int number = in.nextInt();
                    if (number > 0 && number <= guestscount){
                        return guests[--number];
                    } else {
                        System.out.println("Такого номера в списке нет");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public GymMembership newGymMembership(){
        Scanner in = new Scanner(System.in);
        GymMembership gymMembership;
        while (true) {
            Owner owner = getOwner();
            if (owner == null){
                break;
            }
            System.out.println("Выберите тип абонемента:");
            System.out.println("1 - разовый");
            System.out.println("2 - дневной");
            System.out.println("3 - полный");
            int type = in.nextInt();
            switch (type){
                case 1:
                    gymMembership = new SingleGymMembership(LocalDate.now(), )
                case 2:

                case 3:

                default:
                    break;
            }
        }
    }
}
