package ru.jjd.base.fitness;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Gym {
    private GymPart pool;
    private GymPart training;
    private GymPart group;
    private Owner[] guests;
    private int guestscount;
    private GymMembership[] gymMemberships;
    private int gymMembershipsCount;
    private boolean displayVisitInfo;

    public Gym() {
        pool = new GymPart("Бассейн",true, false, true);
        training = new GymPart("Тренажерный зал");
        group = new GymPart("Групповые занятия",false, true, true);
        guests = new Owner[500];
        guestscount = 0;
        gymMemberships = new GymMembership[500];
        gymMembershipsCount = 0;
        setDisplayVisitInfo(true);
    }

    public boolean isDisplayVisitInfo() {
        return displayVisitInfo;
    }

    public void setDisplayVisitInfo(boolean displayVisitInfo) {
        this.displayVisitInfo = displayVisitInfo;
    }

    public void NewDay(){
        pool.newDay();;
        training.newDay();
        group.newDay();
    }

    public void displayGuests(){
        training.displayGuests();
        pool.displayGuests();
        group.displayGuests();
    }

    private Owner getOwner(){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Создать нового посетителя");
            System.out.println("2 - Выбрать из существующих записей");
            System.out.println("3 - Выйти");
            int answer = in.nextInt();
            in.nextLine();
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
                    if (guestscount < 1){
                        System.out.println("Не введено ни одного пользователя");
                    } else {
                        System.out.println("Введите номер посетителя");
                        for (int i = 0; i < guestscount; i++) {
                            System.out.print(i + 1);
                            System.out.println(": " + guests[i].toString());
                        }
                        System.out.print(guestscount);
                        System.out.println(": Выход");
                        int number = in.nextInt();
                        number--;
                        if (number >= 0 && number < guestscount) {
                            return guests[number];
                        } else if (number == guestscount) {
                            return null;
                        } else {
                            System.out.println("Такого номера в списке нет");
                        }
                    }
                    break;
                case 3:
                    return null;
                default:
                    break;
            }
        }
    }

    public GymMembership newGymMembership(){
        Scanner in = new Scanner(System.in);
        LocalDate registrationDate;
        long days;
        GymMembership gymMembership = null;
        while (true) {
            Owner owner = getOwner();
            if (owner == null){
                break;
            }
            System.out.println("Выберите тип абонемента:");
            System.out.println("1 - разовый");
            System.out.println("2 - дневной");
            System.out.println("3 - полный");
            System.out.println("4 - выйти");
            int type = in.nextInt();
            in.nextLine();
            System.out.println("Введите дату начала действия абонемента в формате ГГГГ-ММ-ДД");
            registrationDate = LocalDate.parse(in.nextLine());
            switch (type){
                case 1:
                    gymMembership = new SingleGymMembership(registrationDate, owner);
                    break;
                case 2:
                    System.out.println("Введите срок действия абонемента в днях");
                    days = in.nextLong();
                    gymMembership = new DailyGymMembership(registrationDate, registrationDate.plusDays(--days), owner);
                    break;
                case 3:
                    System.out.println("Введите срок действия абонемента в днях");
                    days = in.nextLong();
                    gymMembership = new FullGymMembership(registrationDate, registrationDate.plusDays(--days), owner);
                    break;
                case 4:
                    return null;
                default:
                    continue;
            }
            return gymMembership;
        }
        return gymMembership;
    }

    private GymMembership chooseGymMembership(){
        Scanner in = new Scanner(System.in);
        if (gymMembershipsCount < 1){
            System.out.println("Не сохранено ни одного абонемента");
            return null;
        }
        System.out.println("Выберите номер абонемента");
        for (int i = 0; i < gymMembershipsCount; i++) {
            System.out.print(i + 1);
            System.out.println(": " + gymMemberships[i].toString());
        }
        System.out.print(gymMembershipsCount + 1);
        System.out.println(": Выход");
        while (true) {
            int number = in.nextInt();
            number--;
            if (number >= 0 && number < gymMembershipsCount) {
                return gymMemberships[number];
            } else if (number == gymMembershipsCount) {
                return null;
            } else {
                System.out.println("Абонемента с таким номером не существует, введите корректный номер");
            }
        }
    }

    private GymMembership getGymMembership(){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Создать новый абонемент");
            System.out.println("2 - Выбрать существующий абонемент");
            System.out.println("3 - Выход");
            int number = in.nextInt();
            switch (number){
                case 1:
                    GymMembership gymMembership = newGymMembership();
                    if (gymMembershipsCount < 500){
                        gymMemberships[gymMembershipsCount] = gymMembership;
                        gymMembershipsCount++;
                    }
                    return gymMembership;
                case 2:
                    return chooseGymMembership();
                case 3:
                    return null;
                default:
                    break;
            }
        }
    }

    public void visit(GymMembership gymMembership){
        Scanner in = new Scanner(System.in);
        if (gymMembership == null){
            gymMembership = getGymMembership();
        }
        if (gymMembership == null){
            return;
        }
        if (gymMembership.getRegistrationDate().isAfter(LocalDate.now()) ||
                gymMembership.getRegistrationEndDate().isBefore(LocalDate.now())){
            System.out.println("Абонемент недействителен на текущий момент");
            return;
        }
        while (true) {
            System.out.println("1 - Бассейн");
            System.out.println("2 - Тренажерный зал");
            System.out.println("3 - Групповые занятия");
            System.out.println("4 - Выход");
            int number = in.nextInt();
            switch (number){
                case 1:
                    if (pool.appendNew(gymMembership) && isDisplayVisitInfo()){
                        System.out.println(gymMembership.getOwner().getSurname() + " " +
                                gymMembership.getOwner().getName() + pool.getName() + " " +
                                LocalDate.now() + " " + LocalTime.now());
                    }
                    break;
                case 2:
                    if (training.appendNew(gymMembership) && isDisplayVisitInfo()){
                        System.out.println(gymMembership.getOwner().getSurname() + " " +
                                gymMembership.getOwner().getName() + training.getName() + " " +
                                LocalDate.now() + " " + LocalTime.now());
                    }
                    break;
                case 3:
                    if (group.appendNew(gymMembership) && isDisplayVisitInfo()){
                        System.out.println(gymMembership.getOwner().getSurname() + " " +
                                gymMembership.getOwner().getName() + group.getName() + " " +
                                LocalDate.now() + " " + LocalTime.now());
                    }
                    break;
                case 4:
                    return;
                default:
                    break;
            }

        }
    }
}
