package homework.additionaltasks.branchesandcycles;

import java.util.Scanner;

public class Task2 {
//Проверка числа на четность
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число для проверки");
        int num = in.nextInt();
        if (num % 2 == 0) System.out.println("Число четное");
        else System.out.println("Число нечетное");
    }
}
