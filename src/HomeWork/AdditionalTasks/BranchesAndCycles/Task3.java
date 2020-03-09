package HomeWork.AdditionalTasks.BranchesAndCycles;

import java.util.Scanner;

public class Task3 {
//Вывод наименьшего числа
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите два числа");
        int num1 = in.nextInt(), num2 = in.nextInt();
        int res;
        if (num1 < num2) res = num1;
        else res = num2;
        System.out.println("Наименьшее число: " + res);
    }
}
