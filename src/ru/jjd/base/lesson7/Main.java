package ru.jjd.base.lesson7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //вызов статических методов осуществляется по имени класса
        Scanner in = new Scanner(System.in);
        System.out.println("Введите тип первого юнита");
        BattleUnit unit1 = BattleUnit.getBattleUnit(in.nextLine());
        System.out.println("Введите тип второго юнита");
        BattleUnit unit2 = BattleUnit.getBattleUnit(in.nextLine());
        //при создании объекта родительского класса с использованием конструктора дочернего класса -
        //уникальные свойства будут заполнены в конструкторе, но уникальные методы и свойства доступны не будут
        unit1.attack(unit2);
    }
}
