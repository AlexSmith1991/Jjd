package ru.jjd.base.examfarm;

public class Main {
    public static void main(String[] args) {
        Farmer farmer = new Farmer();
        Farm farm = new Farm();
        while (farm.dayOnFarm(farmer));
        System.out.println("Прошло " + farm.getDays() + " дней");
    }
}
